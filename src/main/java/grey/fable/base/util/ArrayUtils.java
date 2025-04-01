package grey.fable.base.util;

import java.lang.reflect.Array;

/**
 * 数组工具类.
 *
 * @author GreyFable
 * @since 2025/2/18 16:52
 */
public class ArrayUtils {

    private ArrayUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * 判断对象是否为数组.
     *
     * @param obj 对象
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/18 17:10
     */
    public static boolean isArray(Object obj) {
        return null != obj && obj.getClass().isArray();
    }

    /**
     * 获取数组长度.
     *
     * @param obj 对象
     * @return {@link int}
     * @author GreyFable
     * @since 2025/2/18 17:13
     */
    public static int getLength(Object obj) {
        return isArray(obj) ? Array.getLength(obj) : 0;
    }

    /**
     * 判断数组是否为空.
     *
     * @param obj 对象
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/18 17:14
     */
    public static boolean isEmpty(Object obj) {
        return 0 == getLength(obj);
    }

    /**
     * 判断数组是否不为空.
     *
     * @param obj 对象
     * @return {@code boolean}
     * @author GreyFable
     * @since 2025/2/18 17:16
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 通过参数构建数组.
     *
     * @param values 数组元素
     * @return {@code T[]}
     * @author GreyFable
     * @since 2025/2/18 17:17
     */
    @SafeVarargs
    public static <T> T[] array(T... values) {
        return values;
    }
}
