package grey.fable.base.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 网络工具类
 *
 * @author GreyFable
 * @since 2024/7/26 14:18
 */
public class NetUtil {

    private NetUtil() {
    }

    /**
     * 获取本地主机地址, 从系统中检索主机的名称, 然后将该名称解析为 {@link InetAddress}
     *
     * @return {@link InetAddress}
     * @author GreyFable
     * @since 2024/7/26 14:19
     */
    public static InetAddress getLocalHost() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }

    /**
     * 获取本地主机 IP 地址
     *
     * @return {@link String}
     * @author GreyFable
     * @since 2024/7/26 14:20
     */
    public static String getLocalHostAddress() throws UnknownHostException {
        return getLocalHost().getHostAddress();
    }

    /**
     * 获取本地主机硬件(MAC)地址数组
     *
     * @return {@code byte[]}
     * @author GreyFable
     * @since 2024/7/26 14:20
     */
    public static byte[] getLocalHardwareAddress() throws UnknownHostException, SocketException {
        return getHardwareAddress(getLocalHost());
    }

    /**
     * 获取指定地址信息中的硬件(MAC)地址数组
     *
     * @param inetAddress {@link InetAddress}
     * @return {@code byte[]}
     * @author GreyFable
     * @since 2024/7/26 14:35
     */
    public static byte[] getHardwareAddress(InetAddress inetAddress) throws SocketException {
        if (null == inetAddress) {
            return new byte[0];
        }

        // 通过地址信息获取网络接口, 然后通过网络接口获取硬件地址
        final NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
        return null == networkInterface ? new byte[0] : networkInterface.getHardwareAddress();
    }

    /**
     * 获取本地主机硬件(MAC)地址字符串
     *
     * @return {@link String}
     * @author GreyFable
     * @since 2024/7/26 17:29
     */
    public static String getMacAddress() throws SocketException, UnknownHostException {
        byte[] mac = getLocalHardwareAddress();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < mac.length; i++) {
            if (0 != i) {
                builder.append("-");
            }

            /*
             * 字节转换为整数, 0xFF 表示 16 进制, 转换为十进制即为 255, 二进制表示为: 0000 0000 0000 0000 0000 0000 1111 1111
             * 当 byte 要转化为 int 的时候, 负数高的 24 位必然会补1, 这样, 其二进制补码已经不一致了
             * 通过 & 0xFF 可以将高的 24 位置为 0, 低 8 位保持原样, 保证二进制数据的一致性
             */
            String str = Integer.toHexString(mac[i] & 0xFF);
            if (1 == str.length()) {
                builder.append("0").append(str);
            } else {
                builder.append(str);
            }
        }
        return builder.toString();
    }
}