package ua.com.serhii.util;

import java.security.SecureRandom;

import com.google.common.io.BaseEncoding;

public final class RandomUtil {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private RandomUtil() {
    }

    public static String generateToken() {
        return generateToken(128);
    }

    public static String generateToken(final int size) {
        byte[] byteArr = new byte[size];
        SECURE_RANDOM.nextBytes(byteArr);
        return BaseEncoding.base64Url().omitPadding().encode(byteArr);
    }
}
