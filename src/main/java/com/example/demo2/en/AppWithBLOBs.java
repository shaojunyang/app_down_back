package com.example.demo2.en;

public class AppWithBLOBs extends App {
    private String version;

    private String appStrogeUrl;

    private String iconUrl;

    private String appPlist;

    private String apiToken;

    private String desc;

    private String shortIdDesc;

    private String installUrl;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getAppStrogeUrl() {
        return appStrogeUrl;
    }

    public void setAppStrogeUrl(String appStrogeUrl) {
        this.appStrogeUrl = appStrogeUrl == null ? null : appStrogeUrl.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getAppPlist() {
        return appPlist;
    }

    public void setAppPlist(String appPlist) {
        this.appPlist = appPlist == null ? null : appPlist.trim();
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken == null ? null : apiToken.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getShortIdDesc() {
        return shortIdDesc;
    }

    public void setShortIdDesc(String shortIdDesc) {
        this.shortIdDesc = shortIdDesc == null ? null : shortIdDesc.trim();
    }

    public String getInstallUrl() {
        return installUrl;
    }

    public void setInstallUrl(String installUrl) {
        this.installUrl = installUrl == null ? null : installUrl.trim();
    }
}