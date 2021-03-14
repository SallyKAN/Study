public class isValidNumber {
    public static int isValid(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean posi = true;
        int result = 0;
        int digit = 0;
        int minLastTwo = Integer.MIN_VALUE / 10;
        int minLastOne = Integer.MIN_VALUE % 10;
        for (int i = 0; i < chars.length; i++) {
            if (chars[0] < '0') {
                if (chars[0] == '-') {
                    posi = false;
                    if (chars.length == 1) {
                        return 0;
                    }
                } else if (chars[0] != '+') {
                    return 0;
                }
            }
            if (!Character.isDigit(chars[i])) {
                return 0;
            }
        }
        for (int i = posi ? 0 : 1; i < chars.length; i++) {
            digit = '0' - chars[i];
            if (result < minLastTwo || (result == minLastTwo && digit < minLastOne)) {
                return 0;
            }
            result = result * 10 + digit;
        }
        if (posi == true && result == Integer.MIN_VALUE) {
            return 0;
        }
        return posi ? -result : result;
    }


    public static void main(String[] args) {
        System.out.println('2');
        System.out.println(2);
//        System.out.println(isValid("2147483648"));
    }
}