package com.paulzhangcc.demo.dao.oracle.mapper;

import com.paulzhangcc.demo.dao.oracle.DO.DemoDO;
import org.apache.ibatis.jdbc.SQL;

public class DemoSqlProvider {

    public String insertSelective(DemoDO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("DEMO");
        
        sql.VALUES("ID", "#{id,jdbcType=NUMERIC}");
        
        if (record.getUserName() != null) {
            sql.VALUES("USER_NAME", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("AMOUNT", "#{amount,jdbcType=NUMERIC}");
        }
        
        if (record.getAge() != null) {
            sql.VALUES("AGE", "#{age,jdbcType=NUMERIC}");
        }
        
        if (record.getCash() != null) {
            sql.VALUES("CASH", "#{cash,jdbcType=NUMERIC}");
        }
        
        if (record.getComment() != null) {
            sql.VALUES("\"COMMENT\"", "#{comment,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DemoDO record) {
        SQL sql = new SQL();
        sql.UPDATE("DEMO");
        
        if (record.getUserName() != null) {
            sql.SET("USER_NAME = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("AMOUNT = #{amount,jdbcType=NUMERIC}");
        }
        
        if (record.getAge() != null) {
            sql.SET("AGE = #{age,jdbcType=NUMERIC}");
        }
        
        if (record.getCash() != null) {
            sql.SET("CASH = #{cash,jdbcType=NUMERIC}");
        }
        
        if (record.getComment() != null) {
            sql.SET("\"COMMENT\" = #{comment,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=NUMERIC}");
        
        return sql.toString();
    }
}