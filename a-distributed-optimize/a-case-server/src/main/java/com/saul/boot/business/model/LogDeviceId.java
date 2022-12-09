package com.saul.boot.business.model;

import java.io.Serializable;

/***
 * @DESCRIPTION: 日志上传deviceid接收
 * @author 枫伦
 * @params:
 * @return:
 * @Date: 2021/5/17 3:03 下午
 * @Modified By:
 */
public class LogDeviceId implements Serializable {


    private static final long serialVersionUID = 5736269775080703450L;
    /***设备id*/
    private String deviceId;
    /***不同的平台deviceId的算法可能不一样所以要做区分*/
    private String platformName;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
}