package io.imking.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.imking.common.domain.ImkUser;
import io.imking.utils.Result;
import io.imking.utils.ResultEnum;
import io.imking.utils.SpringUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

	public JWTLoginFilter(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager); 
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
			String authorization = request.getHeader("Authorization"); 
			if(StringUtils.isBlank(authorization) ){
				return super.attemptAuthentication(request, response)  ;  
			}
			ImkUser user = new ObjectMapper().readValue(request.getInputStream() , ImkUser.class);
			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(user.getAccount(), user.getPwd(), new ArrayList<>() ));
		} catch (IOException e) {
			throw new RuntimeException( e ); 
		}
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req; 
		if(StringUtils.equalsIgnoreCase(request.getMethod(), "POST")){
			super.doFilter(request, res, chain);
			return ;
		}
		chain.doFilter(request, res );
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) {
		 Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
         // 定义存放角色集合的对象
         List roleList = new ArrayList<>();
         for (GrantedAuthority grantedAuthority : authorities) {
             roleList.add(grantedAuthority.getAuthority());
         }
         //生成token
		String token = Jwts.builder()
				.setSubject(auth.getName()+"_"+roleList.toString())
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
				.signWith(SignatureAlgorithm.HS512, "MyJwtSecret").compact();
		response.addHeader("Authorization", token);
		try {
			Result<Object> result = new Result<Object>(ResultEnum.SUCCESS, auth.getName()+"_"+roleList.toString()) ;
			 ObjectMapper mapper = new ObjectMapper();
			response.getWriter().write( mapper.writeValueAsString( result ) ); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
