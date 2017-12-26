package com.paulzhangcc.sharing.message.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AliSms implements InsertDB{
    public static  final String CHANNEL = "ALIYUN";
    //手机号
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
        return TemplateParam;
    }

    public AliSms setTemplateParam(Map<String, String> templateParam) {
        TemplateParam = templateParam;
        return this;
    }
    //短信内容
    private String templateCode;

    private Map<String,String> TemplateParam = new HashMap<>();

    @Override
    public String toString() {
        return "AliSms{" +
                "mobile='" + mobile + '\'' +
                ", templateCode='" + templateCode + '\'' +
                ", TemplateParam=" + TemplateParam +
                '}';
    }

    @Override
    public List<InsertBeanDB> insert() {
        List<InsertBeanDB> list = new ArrayList<>();
        InsertBeanDB insertBeanDB = new InsertBeanDB();
        insertBeanDB.setChannel(CHANNEL);
        insertBeanDB.setMobile(mobile);
        insertBeanDB.setContent(this.toString());
        list.add(insertBeanDB);
        return list;
    }
}
