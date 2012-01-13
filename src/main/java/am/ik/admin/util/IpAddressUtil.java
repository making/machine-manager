package am.ik.admin.util;

import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class IpAddressUtil {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(IpAddressUtil.class);

    public static String ipToHex(String ip) {
        String[] bits = ip.split("\\.");
        Assert.isTrue(bits.length == 4);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bits.length; i++) {
            sb.append(String.format("%02x", Integer.parseInt(bits[i])));
        }
        return sb.toString();
    }

    public static String hexToIp(String hex) {
        StringBuilder sb = new StringBuilder();
        Assert.isTrue(hex.length() == 8);
        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                sb.append(".");
            }
            sb.append(Integer.parseInt(hex.substring(i * 2, (i + 1) * 2), 16));
        }
        return sb.toString();
    }

    public static boolean ping(String ip) {
        String[] command = { "ping", SystemUtils.IS_OS_WINDOWS ? "-n" : "-c",
                "1", ip };
        try {
            return new ProcessBuilder(command).start().waitFor() == 0;
        } catch (Exception e) {
            LOGGER.warn("failed to ping " + ip, e);
            return false;
        }
    }
}
