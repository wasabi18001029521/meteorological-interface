package cn.webyun.meteorologicalinterface.message.response;

public class ResponseBase {
    private Boolean success = true;
    private String msg = "";

    public ResponseBase() {}
    public ResponseBase(Boolean success) {
        this.success = success;
    }
    public ResponseBase(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
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
}
