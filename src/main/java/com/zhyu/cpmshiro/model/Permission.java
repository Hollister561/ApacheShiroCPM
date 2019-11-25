package com.zhyu.cpmshiro.model;

/**
 * @program: ApacheShiroCPM
 * @description: 权限类
 * @author: zhang yu
 * @create: 2019-11-25 14:45
 */

public class Permission {
    private Integer pid;
    private String name;
    private String url;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
