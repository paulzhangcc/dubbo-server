package com.paulzhangcc.sharing;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author paul
 * @date 2017/12/27
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



}
