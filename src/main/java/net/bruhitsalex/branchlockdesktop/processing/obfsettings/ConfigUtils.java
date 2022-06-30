package net.bruhitsalex.branchlockdesktop.processing.obfsettings;

import java.security.SecureRandom;

public class ConfigUtils {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generateStacktraceKey() {
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            result.append(charset.charAt(SECURE_RANDOM.nextInt(charset.length())));
        }
        return result.toString();
    }

}
