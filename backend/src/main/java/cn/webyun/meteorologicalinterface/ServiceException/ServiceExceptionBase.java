package cn.webyun.meteorologicalinterface.ServiceException;

public class ServiceExceptionBase extends RuntimeException {
    public ServiceExceptionBase() {
        super();
    }

    public ServiceExceptionBase(String message) {
        super(message);
    }

    public ServiceExceptionBase(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceExceptionBase(Throwable cause) {
        super(cause);
    }

    protected ServiceExceptionBase(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
