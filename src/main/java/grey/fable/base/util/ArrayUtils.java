package grey.fable.base.util;

import java.lang.reflect.Array;

/**
 * {@code Array} 工具类.
 *
 * @author GreyFable
 * @since 2024/8/13 10:50
 */
public final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * 判断对象是否为数组对象.
     *
     * @param obj {@link Object}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:50
     */
    public static boolean isArray(final Object obj) {
        return null != obj && obj.getClass().isArray();
    }

    /**
     * 获取数组对象的长度, 如果对象不是数组则返回 0.
     *
     * @param array {@link Object}
     * @return {@code int}
     * @author GreyFable
     * @since 2024/8/13 10:51
     */
    public static int getLength(final Object array) {
        return isArray(array) ? Array.getLength(array) : 0;
    }

    /**
     * 判断数组对象是否为空, 如果对象不是数组直接返回 {@code true}.
     *
     * @param array {@link Object}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:51
     */
    public static boolean isArrayEmpty(final Object array) {
        return 0 == getLength(array);
    }

    /**
     * 判断 {@code byte[]} 是否为空.
     *
     * @param bytes {@code byte[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:52
     */
    public static boolean isEmpty(final byte[] bytes) {
        return isArrayEmpty(bytes);
    }

    /**
     * 判断 {@code char[]} 是否为空.
     *
     * @param chars {@code char[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:53
     */
    public static boolean isEmpty(final char[] chars) {
        return isArrayEmpty(chars);
    }

    /**
     * 判断 {@code short[]} 是否为空.
     *
     * @param shorts {@code short[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:53
     */
    public static boolean isEmpty(final short[] shorts) {
        return isArrayEmpty(shorts);
    }

    /**
     * 判断 {@code int[]} 是否为空.
     *
     * @param ints {@code int[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:53
     */
    public static boolean isEmpty(final int[] ints) {
        return isArrayEmpty(ints);
    }

    /**
     * 判断 {@code long[]} 是否为空.
     *
     * @param longs {@code long[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:54
     */
    public static boolean isEmpty(final long[] longs) {
        return isArrayEmpty(longs);
    }

    /**
     * 判断 {@code float[]} 是否为空.
     *
     * @param floats {@code float[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:54
     */
    public static boolean isEmpty(final float[] floats) {
        return isArrayEmpty(floats);
    }

    /**
     * 判断 {@code double[]} 是否为空.
     *
     * @param doubles {@code double[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:54
     */
    public static boolean isEmpty(final double[] doubles) {
        return isArrayEmpty(doubles);
    }

    /**
     * 判断 {@code boolean[]} 是否为空.
     *
     * @param booleans {@code boolean[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:54
     */
    public static boolean isEmpty(final boolean[] booleans) {
        return isArrayEmpty(booleans);
    }

    /**
     * 判断 {@code T[]} 是否为空.
     *
     * @param <T>   Type
     * @param array {@code T[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:54
     */
    public static <T> boolean isEmpty(final T[] array) {
        return isArrayEmpty(array);
    }

    /**
     * 判断 {@code byte[]} 是否不为空.
     *
     * @param bytes {@code byte[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:55
     */
    public static boolean isNotEmpty(final byte[] bytes) {
        return !isEmpty(bytes);
    }

    /**
     * 判断 {@code char[]} 是否不为空.
     *
     * @param chars {@code char[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:55
     */
    public static boolean isNotEmpty(final char[] chars) {
        return !isEmpty(chars);
    }

    /**
     * 判断 {@code short[]} 是否不为空.
     *
     * @param shorts {@code short[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:55
     */
    public static boolean isNotEmpty(final short[] shorts) {
        return !isEmpty(shorts);
    }

    /**
     * 判断 {@code int[]} 是否不为空.
     *
     * @param ints {@code int[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:56
     */
    public static boolean isNotEmpty(final int[] ints) {
        return !isEmpty(ints);
    }

    /**
     * 判断 {@code long[]} 是否不为空.
     *
     * @param longs {@code long[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:56
     */
    public static boolean isNotEmpty(final long[] longs) {
        return !isEmpty(longs);
    }

    /**
     * 判断 {@code float[]} 是否不为空.
     *
     * @param floats {@code float[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:56
     */
    public static boolean isNotEmpty(final float[] floats) {
        return !isEmpty(floats);
    }

    /**
     * 判断 {@code double[]} 是否不为空.
     *
     * @param doubles {@code double[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:56
     */
    public static boolean isNotEmpty(final double[] doubles) {
        return !isEmpty(doubles);
    }

    /**
     * 判断 {@code boolean[]} 是否不为空.
     *
     * @param booleans {@code boolean[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:57
     */
    public static boolean isNotEmpty(final boolean[] booleans) {
        return !isEmpty(booleans);
    }

    /**
     * 判断 {@code T[]} 是否不为空.
     *
     * @param <T>   Type
     * @param array {@code T[]}
     * @return {@code boolean}
     * @author GreyFable
     * @since 2024/8/13 10:57
     */
    public static <T> boolean isNotEmpty(final T[] array) {
        return !isEmpty(array);
    }

    /**
     * 通过参数构建一个数组.
     *
     * @param <T>    Type
     * @param values Values
     * @return {@code T[]}
     * @author GreyFable
     * @since 2024/8/13 10:57
     */
    @SafeVarargs
    public static <T> T[] array(final T... values) {
        return values;
    }
}
