public class pointNewchar {
    public static String pointNewchar(String str, int k) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int uNumber = 0;
        char[] chars = str.toCharArray();
        for (int i = k - 1; i >= 0; i--) {
            if (!isUpper(chars[i])) {
                return str.substring(k, k + 1);
            }
            uNumber++;
        }
        if ((uNumber & 1) == 1) {
            return str.substring(k - 1, k + 1);
        } else {
            return str.substring(k, k + 2);
        }
    }

    public static boolean isUpper(char ch) {
        return (ch >= 65 && ch <= 90);
    }
}
