package com.paulzhangcc.demo.dao.mysql.model;

import java.io.Serializable;

public class DemoDO implements Serializable {
    /**
     * 主键递增id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 
     */
    private Integer age;

    /**
     * demo
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键递增id
     * @return id 主键递增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键递增id
     * @param id 主键递增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户名称
     * @return user_name 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名称
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * @return age 
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     * @param age 
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", age=").append(age);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}