package com.paulzhangcc.demo.dao.oracle.mapper;

import com.paulzhangcc.demo.constant.ConfigConsts;
import com.paulzhangcc.demo.dao.oracle.DO.DemoDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface DemoDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from DEMO",
        "where ID = #{id,jdbcType=NUMERIC}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into DEMO (ID, USER_NAME, ",
        "AMOUNT, AGE, CASH, ",
        "\"COMMENT\")",
        "values (#{id,jdbcType=NUMERIC}, #{userName,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=NUMERIC}, #{age,jdbcType=NUMERIC}, #{cash,jdbcType=NUMERIC}, ",
        "#{comment,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT S_DEMO.NEXTVAL FROM DUAL", keyProperty="id", before=true, resultType=Long.class)
    int insert(DemoDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(DemoDO record);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "ID, USER_NAME, AMOUNT, AGE, CASH, \"COMMENT\"",
        "from DEMO",
        "where ID = #{id,jdbcType=NUMERIC}"
    })
    @ResultMap("com.paulzhangcc.demo.dao.oracle.mapper.DemoDAO.BaseResultMap")
    DemoDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DemoDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update DEMO",
        "set USER_NAME = #{userName,jdbcType=VARCHAR},",
          "AMOUNT = #{amount,jdbcType=NUMERIC},",
          "AGE = #{age,jdbcType=NUMERIC},",
          "CASH = #{cash,jdbcType=NUMERIC},",
          "\"COMMENT\" = #{comment,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=NUMERIC}"
    })
    int updateByPrimaryKey(DemoDO record);


    @Select({
            "select",
            "ID, USER_NAME, AMOUNT, AGE, CASH",
            "from DEMO",
    })
    @ResultMap("com.paulzhangcc.demo.dao.oracle.mapper.DemoDAO.BaseResultMap")
    List<DemoDO> selectAll();

    @Select({
            "select",
            "ID, USER_NAME, AMOUNT, AGE, CASH",
            "from DEMO limit 10 ",
    })
    @ResultMap("com.paulzhangcc.demo.dao.oracle.mapper.DemoDAO.BaseResultMap")
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