package com.paulzhangcc.sharing.message.model;

import java.util.Date;
import java.util.List;

/**
 * @author paul
 * @date 2017/12/26
 */
public interface InsertDB {
    List<InsertBeanDB> insert();

    public static class InsertBeanDB{
        private String mobile;
        private String content;
        private Date createDate = new Date();
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
}
