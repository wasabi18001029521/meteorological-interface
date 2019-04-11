package cn.webyun.meteorologicalinterface.message.response;

public class ResponseError {
    private String errorCode="";
    private String errorInfo="";

    public ResponseError() {
    }


    public ResponseError(String errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseError(String errorCode, String errorInfo) {
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }

    public String getErrorCode() {
        return errorCode;
    }



    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
