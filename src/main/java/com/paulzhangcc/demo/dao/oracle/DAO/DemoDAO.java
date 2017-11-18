package com.paulzhangcc.demo.dao.oracle.DAO;


import com.paulzhangcc.demo.constant.ConfigConsts;
import com.paulzhangcc.demo.dao.oracle.DO.DemoDO;
import com.paulzhangcc.demo.dao.oracle.mapper.DemoMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


@Mapper
public interface DemoDAO extends DemoMapper {
    @Select({
            "select",
            "ID, USER_NAME, AMOUNT, AGE, CASH",
            "from DEMO",
    })
    @Results({
            @Result(column="ID", property="id", jdbcType= JdbcType.DECIMAL, id=true),
            @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
            @Result(column="AGE", property="age", jdbcType=JdbcType.DECIMAL),
            @Result(column="CASH", property="cash", jdbcType=JdbcType.DECIMAL)
    })
    List<DemoDO> selectAll();

    @Select({
            "select",
            "ID, USER_NAME, AMOUNT, AGE, CASH",
            "from DEMO limit 10 ",
    })
    @Results({
            @Result(column="ID", property="id", jdbcType= JdbcType.DECIMAL, id=true),
            @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
            @Result(column="AGE", property="age", jdbcType=JdbcType.DECIMAL),
            @Result(column="CASH", property="cash", jdbcType=JdbcType.DECIMAL)
    })
    List<DemoDO> top10();

    @Select({
            "select",
            "ID, USER_NAME, AMOUNT, AGE, CASH",
            "from DEMO  ",
            ConfigConsts.SQL_LIMIT
    })
    @Results({
            @Result(column="ID", property="id", jdbcType= JdbcType.DECIMAL, id=true),
            @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.DECIMAL),
            @Result(column="AGE", property="age", jdbcType=JdbcType.DECIMAL),
            @Result(column="CASH", property="cash", jdbcType=JdbcType.DECIMAL)
    })
    List<DemoDO> limit(@Param(ConfigConsts.OFFSET) Integer offset, @Param(ConfigConsts.PAGESIZE)Integer pagesize);
}