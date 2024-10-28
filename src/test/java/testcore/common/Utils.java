package testcore.common;

import java.util.Random;

public class Utils {
    private static String generateRandomString(String partenString, int length) {

        StringBuilder value = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = (int) (random.nextFloat() * partenString.length());
            value.append(partenString.charAt(index));
        }
        return value.toString();
    }

    public static String generateRandomUpperString(int length) {
        String partenString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return generateRandomString(partenString, length);
    }

    public static String generateRandomLowercaseString(int length) {
        String partenString = "abcdefghijkmnopqrstuvwxyz";
        return generateRandomString(partenString, length);
    }

    public static String generateRandomNumber(int length) {
        String partenString = "123456789";
        return generateRandomString(partenString, length);
    }
}
