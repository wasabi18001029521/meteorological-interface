package cn.webyun.meteorologicalinterface.ServiceException;

public class PrivilegeException extends ServiceExceptionBase {
    public PrivilegeException() {
        super();
    }

    public PrivilegeException(String message) {
        super(message);
    }

    public PrivilegeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrivilegeException(Throwable cause) {
        super(cause);
    }

    protected PrivilegeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
