package com.goopal.authsys.domain;

import java.util.Date;

public class User {
    private Integer id;

    private String userNum;

    private String password;

    private String realName;

    private Byte sex;

    private String userEmail;

    private String innerEmail;

    private String mobile;

    private Integer departmentId;

    private Date entryDatetime;

    private Date createTime;

    private Date updateTime;
    
    public User() {}

    public User(String userNum, String password, String realName, Byte sex,
            String userEmail, String innerEmail, String mobile, Integer departmentId,
            Date entryDatetime, Date createTime, Date updateTime) {
        this.userNum = userNum;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.userEmail = userEmail;
        this.innerEmail = innerEmail;
        this.mobile = mobile;
        this.departmentId = departmentId;
        this.entryDatetime = entryDatetime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum == null ? null : userNum.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getInnerEmail() {
        return innerEmail;
    }

    public void setInnerEmail(String innerEmail) {
        this.innerEmail = innerEmail == null ? null : innerEmail.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(Date entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}