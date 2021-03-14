import org.junit.Test;

public class isValidString {
    public static boolean isValid(String string) {
        if (string == null) {
            return false;
        }
        char[] chars = string.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left++;
            } else if (chars[i] == ')') {
                right++;
            }else {
                return false;
            }
        }
        return left == right;
    }

    public static void main(String[] args) {
        String test = "(()()";
        System.out.println(isValid(test));
    }
}
