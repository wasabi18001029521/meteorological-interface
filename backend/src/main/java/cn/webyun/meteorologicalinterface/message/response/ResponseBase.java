package cn.webyun.meteorologicalinterface.message.response;

import cn.webyun.meteorologicalinterface.entity.User;

public class ResponseBase {
    private Boolean success = true;
    private String msg = "";
    private Integer id;
    private String username;
    private String user_key;
    private String user_register;
    private String user_login;

    public ResponseBase() {}
    public ResponseBase(Boolean success) {
        this.success = success;
    }
    public ResponseBase(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
    public ResponseBase(User user,Boolean success,String msg) {
        this.id=user.getId();
        this.username=user.getUserName();
        this.user_key=user.getUser_key();
        this.user_register=user.getUser_register();
        this.user_login=user.getUser_login();
        this.success=success;
        this.msg=msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
