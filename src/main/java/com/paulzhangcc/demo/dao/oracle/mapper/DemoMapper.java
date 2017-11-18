package com.paulzhangcc.demo.dao.oracle.mapper;

import com.paulzhangcc.demo.dao.oracle.DO.DemoDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DemoMapper {
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
    @InsertProvider(type=DemoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT S_DEMO.NEXTVAL FROM DUAL", keyProperty="id", before=true, resultType=Long.class)
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
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.NUMERIC, id=true),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="AMOUNT", property="amount", jdbcType=JdbcType.NUMERIC),
        @Result(column="AGE", property="age", jdbcType=JdbcType.NUMERIC),
        @Result(column="CASH", property="cash", jdbcType=JdbcType.NUMERIC),
        @Result(column="COMMENT", property="comment", jdbcType=JdbcType.VARCHAR)
    })
    DemoDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @UpdateProvider(type=DemoSqlProvider.class, method="updateByPrimaryKeySelective")
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
}