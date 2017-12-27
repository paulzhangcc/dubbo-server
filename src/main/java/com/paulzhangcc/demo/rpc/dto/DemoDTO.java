package com.paulzhangcc.demo.rpc.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class DemoDTO implements Serializable{

    private static final long serialVersionUID = 8168144799694305358L;

    private Long id;

    private String userName;

    private BigDecimal amount;

    private Integer age;

    private BigDecimal cash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "DemoDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", amount=" + amount +
                ", age=" + age +
                ", cash=" + cash +
                '}';
    }
}
