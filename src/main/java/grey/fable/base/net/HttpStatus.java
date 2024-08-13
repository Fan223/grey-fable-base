package grey.fable.base.net;

/**
 * HTTP 状态码类.
 *
 * @author GreyFable
 * @since 2024/8/12 18:00
 */
public final class HttpStatus {

    // 1xx, Informational.
    /**
     * 100, 继续.
     */
    public static final int HTTP_CONTINUE = 100;

    /**
     * 101, 切换协议.
     */
    public static final int HTTP_SWITCHING_PROTOCOLS = 101;

    // 2xx, Successful.
    /**
     * 200, 确定.
     */
    public static final int HTTP_OK = 200;

    /**
     * 201, 已创建.
     */
    public static final int HTTP_CREATED = 201;

    /**
     * 202, 已接受.
     */
    public static final int HTTP_ACCEPTED = 202;

    /**
     * 203, 非权威信息.
     */
    public static final int HTTP_NON_AUTHORITATIVE_INFORMATION = 203;

    /**
     * 204, 无内容.
     */
    public static final int HTTP_NO_CONTENT = 204;

    /**
     * 205, 重置内容.
     */
    public static final int HTTP_RESET_CONTENT = 205;

    /**
     * 206, 部分内容.
     */
    public static final int HTTP_PARTIAL_CONTENT = 206;

    // 3xx, Redirection.
    /**
     * 300, 多项选择.
     */
    public static final int HTTP_MULTIPLE_CHOICES = 300;

    /**
     * 301, 永久移动.
     */
    public static final int HTTP_MOVED_PERMANENTLY = 301;

    /**
     * 302, 临时移动. 目前还是以 FOUND 为首选项.
     */
    public static final int HTTP_MOVED_TEMPORARILY = 302;

    /**
     * 302, 已找到.
     */
    public static final int HTTP_FOUND = 302;

    /**
     * 303, 参见其他内容.
     */
    public static final int HTTP_SEE_OTHER = 303;

    /**
     * 304, 未修改.
     */
    public static final int HTTP_NOT_MODIFIED = 304;

    /**
     * 305, 使用代理.
     */
    public static final int HTTP_USE_PROXY = 305;

    /**
     * 307, 临时重定向.
     */
    public static final int HTTP_TEMPORARY_REDIRECT = 307;

    // 4xx, Client error.
    /**
     * 400, 错误请求.
     */
    public static final int HTTP_BAD_REQUEST = 400;

    /**
     * 401, 未授权.
     */
    public static final int HTTP_UNAUTHORIZED = 401;

    /**
     * 402, 需付款.
     */
    public static final int HTTP_PAYMENT_REQUIRED = 402;

    /**
     * 403, 禁止.
     */
    public static final int HTTP_FORBIDDEN = 403;

    /**
     * 404, 未找到.
     */
    public static final int HTTP_NOT_FOUND = 404;

    /**
     * 405, 方法不被允许.
     */
    public static final int HTTP_METHOD_NOT_ALLOWED = 405;

    /**
     * 406, 不可接受.
     */
    public static final int HTTP_NOT_ACCEPTABLE = 406;

    /**
     * 407, 需要代理身份验证.
     */
    public static final int HTTP_PROXY_AUTHENTICATION_REQUIRED = 407;

    /**
     * 408, 请求超时.
     */
    public static final int HTTP_REQUEST_TIMEOUT = 408;

    /**
     * 409, 冲突.
     */
    public static final int HTTP_CONFLICT = 409;

    /**
     * 410, 已删除.
     */
    public static final int HTTP_GONE = 410;

    /**
     * 411, 需要长度.
     */
    public static final int HTTP_LENGTH_REQUIRED = 411;

    /**
     * 412, 前提条件失败.
     */
    public static final int HTTP_PRECONDITION_FAILED = 412;

    /**
     * 413, 请求实体过大.
     */
    public static final int HTTP_REQUEST_ENTITY_TOO_LARGE = 413;

    /**
     * 414, 请求 URI 过长.
     */
    public static final int HTTP_REQUEST_URI_TOO_LONG = 414;

    /**
     * 415, 不支持的媒体类型.
     */
    public static final int HTTP_UNSUPPORTED_MEDIA_TYPE = 415;

    /**
     * 416, 请求范围不满足.
     */
    public static final int HTTP_REQUESTED_RANGE_NOT_SATISFIABLE = 416;

    /**
     * 417, 期望失败.
     */
    public static final int HTTP_EXPECTATION_FAILED = 417;

    // 5xx, Server error.
    /**
     * 500, 内部服务器错误.
     */
    public static final int HTTP_INTERNAL_SERVER_ERROR = 500;

    /**
     * 501, 未实现.
     */
    public static final int HTTP_NOT_IMPLEMENTED = 501;

    /**
     * 502, 错误网关.
     */
    public static final int HTTP_BAD_GATEWAY = 502;

    /**
     * 503, 服务不可用.
     */
    public static final int HTTP_SERVICE_UNAVAILABLE = 503;

    /**
     * 504, 网关超时.
     */
    public static final int HTTP_GATEWAY_TIMEOUT = 504;

    /**
     * 505, 不支持 HTTP 版本.
     */
    public static final int HTTP_VERSION_NOT_SUPPORTED = 505;

    private HttpStatus() {
    }
}
