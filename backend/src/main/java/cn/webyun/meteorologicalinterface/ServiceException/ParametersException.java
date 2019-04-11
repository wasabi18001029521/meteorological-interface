package cn.webyun.meteorologicalinterface.ServiceException;

public class ParametersException extends ServiceExceptionBase{
    public ParametersException() {
        super();
    }

    public ParametersException(String message) {
        super(message);
    }

    public ParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParametersException(Throwable cause) {
        super(cause);
    }

    protected ParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
