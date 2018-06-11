package io.imking.reward.mapping;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import io.imking.reward.domain.RwAsk;
import io.imking.reward.domain.RwAskExample;

@Mapper
public interface RwAskMapper {
    @SelectProvider(type=RwAskSqlProvider.class, method="countByExample")
    long countByExample(RwAskExample example);

    @DeleteProvider(type=RwAskSqlProvider.class, method="deleteByExample")
    int deleteByExample(RwAskExample example);

    @Delete({
        "delete from rw_ask",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rw_ask (id, rw_ask_index, ",
        "current_answer_user_id, type, ",
        "title, content, ",
        "attach_group, is_top, ",
        "top_amount, top_expiration_date, ",
        "task_amount, crowdfunding_amount, ",
        "status, status_change_time, ",
        "create_by, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{rwAskIndex,jdbcType=TINYINT}, ",
        "#{currentAnswerUserId,jdbcType=INTEGER}, #{type,jdbcType=TINYINT}, ",
        "#{title,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{attachGroup,jdbcType=VARCHAR}, #{isTop,jdbcType=BIT}, ",
        "#{topAmount,jdbcType=INTEGER}, #{topExpirationDate,jdbcType=TIMESTAMP}, ",
        "#{taskAmount,jdbcType=INTEGER}, #{crowdfundingAmount,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT}, #{statusChangeTime,jdbcType=TIMESTAMP}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(RwAsk record);

    @InsertProvider(type=RwAskSqlProvider.class, method="insertSelective")
    int insertSelective(RwAsk record);

    @SelectProvider(type=RwAskSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="current_answer_user_id", property="currentAnswerUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach_group", property="attachGroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.BIT),
        @Result(column="top_amount", property="topAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="top_expiration_date", property="topExpirationDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_amount", property="taskAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="crowdfunding_amount", property="crowdfundingAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="status_change_time", property="statusChangeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RwAsk> selectByExample(RwAskExample example);

    @Select({
        "select",
        "id, rw_ask_index, current_answer_user_id, type, title, content, attach_group, ",
        "is_top, top_amount, top_expiration_date, task_amount, crowdfunding_amount, status, ",
        "status_change_time, create_by, create_time, update_time",
        "from rw_ask",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rw_ask_index", property="rwAskIndex", jdbcType=JdbcType.TINYINT),
        @Result(column="current_answer_user_id", property="currentAnswerUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="attach_group", property="attachGroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_top", property="isTop", jdbcType=JdbcType.BIT),
        @Result(column="top_amount", property="topAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="top_expiration_date", property="topExpirationDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="task_amount", property="taskAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="crowdfunding_amount", property="crowdfundingAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="status_change_time", property="statusChangeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RwAsk selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RwAskSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RwAsk record, @Param("example") RwAskExample example);

    @UpdateProvider(type=RwAskSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RwAsk record, @Param("example") RwAskExample example);

    @UpdateProvider(type=RwAskSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RwAsk record);

    @Update({
        "update rw_ask",
        "set rw_ask_index = #{rwAskIndex,jdbcType=TINYINT},",
          "current_answer_user_id = #{currentAnswerUserId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "attach_group = #{attachGroup,jdbcType=VARCHAR},",
          "is_top = #{isTop,jdbcType=BIT},",
          "top_amount = #{topAmount,jdbcType=INTEGER},",
          "top_expiration_date = #{topExpirationDate,jdbcType=TIMESTAMP},",
          "task_amount = #{taskAmount,jdbcType=INTEGER},",
          "crowdfunding_amount = #{crowdfundingAmount,jdbcType=INTEGER},",
          "status = #{status,jdbcType=TINYINT},",
          "status_change_time = #{statusChangeTime,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RwAsk record);


    /**
     * 开放红包抢红包更新
     *
     * @param record
     * @param status
     * @return int
     */
    @Update({ "update rw_ask", "set rw_ask_index = #{record.rwAskIndex,jdbcType=TINYINT},",
            "current_answer_user_id = #{record.currentAnswerUserId,jdbcType=INTEGER},",
            "type = #{record.type,jdbcType=TINYINT},", "title = #{record.title,jdbcType=VARCHAR},",
            "content = #{record.content,jdbcType=VARCHAR},", "attach_group = #{record.attachGroup,jdbcType=VARCHAR},",
            "is_top = #{record.isTop,jdbcType=BIT},", "top_amount = #{record.topAmount,jdbcType=DECIMAL},",
            "top_expiration_date = #{record.topExpirationDate,jdbcType=TIMESTAMP},",
            "task_amount = #{record.taskAmount,jdbcType=DECIMAL},",
            "crowdfunding_amount = #{record.crowdfundingAmount,jdbcType=DECIMAL},",
            "status = #{record.status,jdbcType=TINYINT},",
            "status_change_time = #{record.statusChangeTime,jdbcType=TIMESTAMP},",
            "create_by = #{record.createBy,jdbcType=INTEGER},",
            "create_time = #{record.createTime,jdbcType=TIMESTAMP},",
            "update_time = #{record.updateTime,jdbcType=TIMESTAMP}",
            "where id = #{record.id,jdbcType=INTEGER} and status=#{status,jdbcType=TINYINT}" })
    int updateRwAsk(@Param("record") io.imking.reward.domain.RwAsk record, @Param("status") int status);

}