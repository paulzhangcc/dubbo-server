package com.paulzhangcc.sharing.message.model;

import java.util.*;
/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class AliSms implements MessageInsertDatabase {
    public static  final String CHANNEL = "ALIYUN";
    /**
     * 手机号
     */
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public AliSms setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public AliSms setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
        return this;
    }

    public Map<String, String> getTemplateParam() {
        return templateParam;
    }

    public AliSms setTemplateParam(Map<String, String> templateParam) {
        templateParam = templateParam;
        return this;
    }

    /**
     * 模板编号
     */
    private String templateCode;

    private Map<String,String> templateParam = new HashMap<>();

    @Override
    public String toString() {
        return "AliSms{" +
                "mobile='" + mobile + '\'' +
                ", templateCode='" + templateCode + '\'' +
                ", TemplateParam=" + templateParam +
                '}';
    }

    @Override
    public List<MessageDO> insert() {
        List<MessageDO> list = new ArrayList<>();
        MessageDO insertBeanDB = new MessageDO();
        insertBeanDB.setChannel(CHANNEL);
        insertBeanDB.setMobile(mobile);
        insertBeanDB.setContent(this.toString());
        insertBeanDB.setCreateDate(new Date());
        list.add(insertBeanDB);
        return list;
    }
}
