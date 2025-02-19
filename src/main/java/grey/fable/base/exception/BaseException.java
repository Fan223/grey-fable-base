package grey.fable.base.exception;

/**
 * 基础异常类.
 *
 * @author GreyFable
 * @since 2025/2/18 11:16
 */
public class BaseException extends RuntimeException {

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
