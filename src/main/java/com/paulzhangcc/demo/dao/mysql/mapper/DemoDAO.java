package com.paulzhangcc.demo.dao.mysql.mapper;

import com.paulzhangcc.demo.dao.mysql.model.DemoDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.paulzhangcc.demo.constant.ConfigConsts.OFFSET;
import static com.paulzhangcc.demo.constant.ConfigConsts.PAGESIZE;

@Mapper
public interface DemoDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from demo",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into demo (user_name, age)",
        "values (#{userName,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
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
        "id, user_name, age",
        "from demo",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.paulzhangcc.demo.dao.mysql.mapper.DemoDAO.BaseResultMap")
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
        "update demo",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DemoDO record);

    @Select({
            "select",
            "id, user_name, age",
            "from demo",
            "limit #{offset},#{pagesize}"
    })
    @ResultMap("com.paulzhangcc.demo.dao.mysql.mapper.DemoDAO.BaseResultMap")
    List<DemoDO> limit(@Param(OFFSET) Integer offset, @Param(PAGESIZE) Integer pagesize);
}