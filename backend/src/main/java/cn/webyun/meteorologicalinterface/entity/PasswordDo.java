package cn.webyun.meteorologicalinterface.entity;

public class PasswordDo {
    // 用户账号
    private String username;
    // 当前密码
    private String Currentpassword;
    // 新密码
    private String Newpassword;
    // 确认新密码
    private String Confirmthenewpassword;

    public String getCurrentpassword() {
        return Currentpassword;
    }

    public void setCurrentpassword(String currentpassword) {
        Currentpassword = currentpassword;
    }

    public String getNewpassword() {
        return Newpassword;
    }

    public void setNewpassword(String newpassword) {
        Newpassword = newpassword;
    }

    public String getConfirmthenewpassword() {
        return Confirmthenewpassword;
    }

    public void setConfirmthenewpassword(String confirmthenewpassword) {
        Confirmthenewpassword = confirmthenewpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
