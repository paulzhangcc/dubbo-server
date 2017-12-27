package com.paulzhangcc.sharing.message.model;

import java.util.Date;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class MessageDO {
    private String mobile;
    private String content;
    private Date createDate;
    private String channel;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "InsertBeanDB{" +
                "mobile='" + mobile + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", channel='" + channel + '\'' +
                '}';
    }
}
