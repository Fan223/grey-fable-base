package grey.fable.base;

/**
 * 统一响应类.
 *
 * @author GreyFable
 * @since 2025/2/17 6:21
 */
public record Response<T>(int code, String message, T data) {

    public Response(String message, T data) {
        this(200, message, data);
    }

    public Response(T data) {
        this("success", data);
    }
}
