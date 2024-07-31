package grey.fable.base.utils;

import java.lang.reflect.Array;

/**
 * {@code Array} 工具类
 *
 * @author GreyFable
 * @since 2024/7/26 11:35
 */
public class ArrayUtil {
    private ArrayUtil() {
    }

    /**
     * 判断对象是否为数组对象
     *
     * @param obj {@link Object}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 15:43
     */
    public static boolean isArray(Object obj) {
        return null != obj && obj.getClass().isArray();
    }

    /**
     * 判断数组对象是否为空, 如果对象不是数组直接返回 {@code true}
     *
     * @param array {@link Object}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:52
     */
    public static boolean isArrayEmpty(Object array) {
        return 0 == getLength(array);
    }

    /**
     * 获取数组对象的长度, 如果对象不是数组则返回 0
     *
     * @param array {@link Object}
     * @return {@code int}
     * @author GreyFable
     * @since 2024/7/26 16:54
     */
    public static int getLength(Object array) {
        return isArray(array) ? Array.getLength(array) : 0;
    }

    /**
     * 判断 {@code byte[]} 是否为空
     *
     * @param bytes {@code byte[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 15:34
     */
    public static boolean isEmpty(byte[] bytes) {
        return isArrayEmpty(bytes);
    }

    /**
     * 判断 {@code char[]} 是否为空
     *
     * @param chars {@code char[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 15:35
     */
    public static boolean isEmpty(char[] chars) {
        return isArrayEmpty(chars);
    }

    /**
     * 判断 {@code short[]} 是否为空
     *
     * @param shorts {@code short[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 15:35
     */
    public static boolean isEmpty(short[] shorts) {
        return isArrayEmpty(shorts);
    }

    /**
     * 判断 {@code int[]} 是否为空
     *
     * @param ints {@code int[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:38
     */
    public static boolean isEmpty(int[] ints) {
        return isArrayEmpty(ints);
    }

    /**
     * 判断 {@code long[]} 是否为空
     *
     * @param longs {@code long[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:39
     */
    public static boolean isEmpty(long[] longs) {
        return isArrayEmpty(longs);
    }

    /**
     * 判断 {@code float[]} 是否为空
     *
     * @param floats {@code float[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:40
     */
    public static boolean isEmpty(float[] floats) {
        return isArrayEmpty(floats);
    }

    /**
     * 判断 {@code double[]} 是否为空
     *
     * @param doubles {@code double[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:40
     */
    public static boolean isEmpty(double[] doubles) {
        return isArrayEmpty(doubles);
    }

    /**
     * 判断 {@code boolean[]} 是否为空
     *
     * @param booleans {@code boolean[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:40
     */
    public static boolean isEmpty(boolean[] booleans) {
        return isArrayEmpty(booleans);
    }

    /**
     * 判断 {@code T[]} 是否为空
     *
     * @param array {@code T[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 11:35
     */
    public static <T> boolean isEmpty(T[] array) {
        return isArrayEmpty(array);
    }

    /**
     * 判断 {@code byte[]} 是否不为空
     *
     * @param bytes {@code byte[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:47
     */
    public static boolean isNotEmpty(byte[] bytes) {
        return !isEmpty(bytes);
    }

    /**
     * 判断 {@code char[]} 是否不为空
     *
     * @param chars {@code char[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:49
     */
    public static boolean isNotEmpty(char[] chars) {
        return !isEmpty(chars);
    }

    /**
     * 判断 {@code short[]} 是否不为空
     *
     * @param shorts {@code short[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:49
     */
    public static boolean isNotEmpty(short[] shorts) {
        return !isEmpty(shorts);
    }

    /**
     * 判断 {@code int[]} 是否不为空
     *
     * @param ints {@code int[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:49
     */
    public static boolean isNotEmpty(int[] ints) {
        return !isEmpty(ints);
    }

    /**
     * 判断 {@code long[]} 是否不为空
     *
     * @param longs {@code long[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:50
     */
    public static boolean isNotEmpty(long[] longs) {
        return !isEmpty(longs);
    }

    /**
     * 判断 {@code float[]} 是否不为空
     *
     * @param floats {@code float[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:50
     */
    public static boolean isNotEmpty(float[] floats) {
        return !isEmpty(floats);
    }

    /**
     * 判断 {@code double[]} 是否不为空
     *
     * @param doubles {@code double[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:50
     */
    public static boolean isNotEmpty(double[] doubles) {
        return !isEmpty(doubles);
    }

    /**
     * 判断 {@code boolean[]} 是否不为空
     *
     * @param booleans {@code boolean[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 16:50
     */
    public static boolean isNotEmpty(boolean[] booleans) {
        return !isEmpty(booleans);
    }

    /**
     * 判断 {@code T[]} 是否不为空
     *
     * @param array {@code T[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/7/26 11:36
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    /**
     * 通过参数构建一个数组
     *
     * @param values Values
     * @return {@code T[]}
     * @author GreyFable
     * @since 2024/7/26 11:38
     */
    @SafeVarargs
    public static <T> T[] array(T... values) {
        return values;
    }
}