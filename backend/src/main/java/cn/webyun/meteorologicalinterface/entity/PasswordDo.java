package cn.webyun.meteorologicalinterface.entity;

public class PasswordDo {
    // 用户账号
    private String username;
    // 当前密码
    private String password;
    // 新密码
    private String newpassword;
    // 确认新密码
    private String confirmthenewpassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getConfirmthenewpassword() {
        return confirmthenewpassword;
    }

    public void setConfirmthenewpassword(String confirmthenewpassword) {
        this.confirmthenewpassword = confirmthenewpassword;
    }
}
