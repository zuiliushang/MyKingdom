package io.imking.reward.mapping;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import io.imking.reward.domain.RwProAct;
import io.imking.reward.domain.RwProActExample;

@Mapper
public interface RwProActMapper {
    @SelectProvider(type=RwProActSqlProvider.class, method="countByExample")
    long countByExample(RwProActExample example);

    @DeleteProvider(type=RwProActSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwProActExample example);

    @Delete({
        "delete from rw_pro_act",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_pro_act (id, rw_ask_id, ",
        "rw_ask_index, type, ",
        "amount, apply_delay_days, ",
        "create_by, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskId,jdbcType=INTEGER}, ",
        "#{rwAskIndex,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{amount,jdbcType=INTEGER}, #{applyDelayDays,jdbcType=TINYINT}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwProAct record);

    @InsertProvider(type=RwProActSqlProvider.class, method="insertSelective")
    int insertSelective(RwProAct record);

    @SelectProvider(type=RwProActSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_delay_days", property="applyDelayDays", jdbcType=JdbcType.TINYINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwProAct> selectByExample(RwProActExample example);

    @Select({
        "select",
        "id, rw_ask_id, rw_ask_index, type, amount, apply_delay_days, create_by, create_time",
        "from rw_pro_act",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_id", property="rwAskId", jdbcType=JdbcType.INTEGER),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="apply_delay_days", property="applyDelayDays", jdbcType=JdbcType.TINYINT),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwProAct selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwProActSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwProAct record, @Param("example") RwProActExample example);

    @UpdateProvider(type=RwProActSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwProAct record, @Param("example") RwProActExample example);

    @UpdateProvider(type=RwProActSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwProAct record);

    @Update({
        "update rw_pro_act",
        "set rw_ask_id = #{rwAskId,jdbcType=INTEGER},",
          "rw_ask_index = #{rwAskIndex,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "amount = #{amount,jdbcType=INTEGER},",
          "apply_delay_days = #{applyDelayDays,jdbcType=TINYINT},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwProAct record);
}