package grey.fable.base;

/**
 * 响应类
 *
 * @author GreyFable
 * @since 2024/7/26 11:40
 */
public class Response<T> {

    private int code;
    private String message;
    private T data;

    private static class Builder<T> {
        private final Response<T> response = new Response<>();

        public Builder(T data) {
            this.response.data = data;
        }

        private Builder<T> code(int code) {
            this.response.code = code;
            return this;
        }

        private Builder<T> message(String message) {
            this.response.message = message;
            return this;
        }

        private Response<T> build() {
            return this.response;
        }
    }

    /**
     * 返回一个 {@link Response.Builder} 对象, 传入数据以指定泛型
     *
     * @param data Data
     * @return {@link Response.Builder<T>}
     * @author GreyFable
     * @since 2024/7/26 11:46
     */
    private static <T> Builder<T> builder(T data) {
        return new Builder<>(data);
    }

    /**
     * 成功响应, 返回默认代码和消息以及指定数据
     *
     * @param data Data
     * @return {@link Response<T>}
     * @author GreyFable
     * @since 2024/7/26 11:49
     */
    public static <T> Response<T> success(T data) {
        return Response.builder(data).code(200).message("Successful").build();
    }

    /**
     * 成功响应, 返回默认代码以及指定的消息和数据
     *
     * @param message Message
     * @param data    Data
     * @return {@link Response<T>}
     * @author GreyFable
     * @since 2024/7/26 11:51
     */
    public static <T> Response<T> success(String message, T data) {
        return Response.builder(data).code(200).message(message).build();
    }

    /**
     * 成功响应, 返回指定的代码和消息以及数据
     *
     * @param code    Code
     * @param message Message
     * @param data    Data
     * @return {@link Response<T>}
     * @author GreyFable
     * @since 2024/7/26 11:50
     */
    public static <T> Response<T> success(int code, String message, T data) {
        return Response.builder(data).code(code).message(message).build();
    }

    /**
     * 失败响应, 返回默认代码和消息以及指定的数据
     *
     * @param data Data
     * @return {@link Response<T>}
     * @author GreyFable
     * @since 2024/7/26 11:54
     */
    public static <T> Response<T> fail(T data) {
        return Response.builder(data).code(500).message("Failed").build();
    }

    /**
     * 失败响应, 返回默认代码和以及指定的消息和数据
     *
     * @param message Message
     * @param data    Data
     * @return {@link Response<T>}
     * @author GreyFable
     * @since 2024/7/26 11:56
     */
    public static <T> Response<T> fail(String message, T data) {
        return Response.builder(data).code(500).message(message).build();
    }

    /**
     * 失败响应, 返回指定的代码和消息以及数据
     *
     * @param code    Code
     * @param message Message
     * @param data    Data
     * @return {@link Response<T>}
     * @author GreyFable
     * @since 2024/7/26 11:56
     */
    public static <T> Response<T> fail(int code, String message, T data) {
        return Response.builder(data).code(code).message(message).build();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}