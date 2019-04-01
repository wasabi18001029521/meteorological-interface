package cn.webyun.meteorologicalinterface.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String userName;

    private String userFullName;

    private String userPassword;

    private Integer unitId;

    private String unitName;

    private String unitFullName;

    private Boolean accountExpired;

    private Boolean accountLocked;

    private Boolean passwordExpired;

    private Boolean accountEnabled;

    private String email;

    private String address;

    private String phone;

    private String user_key;

    private String user_register;

    private String user_login;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName == null ? null : userFullName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getUnitFullName() {
        return unitFullName;
    }

    public void setUnitFullName(String unitFullName) {
        this.unitFullName = unitFullName == null ? null : unitFullName.trim();
    }

    public Boolean getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public Boolean getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(Boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public Boolean getAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }

    public String getUser_register() {
        return user_register;
    }

    public void setUser_register(String user_register) {
        this.user_register = user_register;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userFullName=").append(userFullName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", unitId=").append(unitId);
        sb.append(", unitName=").append(unitName);
        sb.append(", unitFullName=").append(unitFullName);
        sb.append(", accountExpired=").append(accountExpired);
        sb.append(", accountLocked=").append(accountLocked);
        sb.append(", passwordExpired=").append(passwordExpired);
        sb.append(", accountEnabled=").append(accountEnabled);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
