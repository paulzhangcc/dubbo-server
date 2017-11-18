package com.paulzhangcc.demo.dao.oracle.DO;

import java.io.Serializable;
import java.math.BigDecimal;

public class DemoDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * null
     */
    private String userName;

    /**
     * null
     */
    private BigDecimal amount;

    /**
     * null
     */
    private Integer age;

    /**
     * null
     */
    private BigDecimal cash;

    /**
     * null
     */
    private String comment;

    /**
     * DEMO
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     * @return ID id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * null
     * @return USER_NAME null
     */
    public String getUserName() {
        return userName;
    }

    /**
     * null
     * @param userName null
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * null
     * @return AMOUNT null
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * null
     * @param amount null
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * null
     * @return AGE null
     */
    public Integer getAge() {
        return age;
    }

    /**
     * null
     * @param age null
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * null
     * @return CASH null
     */
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * null
     * @param cash null
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    /**
     * null
     * @return COMMENT null
     */
    public String getComment() {
        return comment;
    }

    /**
     * null
     * @param comment null
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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
        sb.append(", amount=").append(amount);
        sb.append(", age=").append(age);
        sb.append(", cash=").append(cash);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}