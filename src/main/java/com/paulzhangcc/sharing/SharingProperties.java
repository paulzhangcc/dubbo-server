package com.paulzhangcc.sharing;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
@ConfigurationProperties(prefix = "custom.sharing", ignoreUnknownFields = true)
@Component
public class SharingProperties {

    public Boolean getOpenSms() {
        return isOpenSms;
    }

    public void setOpenSms(Boolean openSms) {
        isOpenSms = openSms;
    }

    private Boolean isOpenSms = Boolean.TRUE ;


    public String getFileSystemRoot() {
        return fileSystemRoot;
    }

    public void setFileSystemRoot(String fileSystemRoot) {
        this.fileSystemRoot = fileSystemRoot;
    }

    private String fileSystemRoot = "/";



}
