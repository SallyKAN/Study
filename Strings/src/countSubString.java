public class countSubString {
    public static String countSubString(String str) {
        if (str == null | str.equals("")) {
            return null;
        }
        char[] chars = str.toCharArray();
        String res = String.valueOf(chars[0]);
        int num = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                num++;
            } else {
                res = res + "_" + num + "_" + chars[i];
                num = 1;
            }
        }
        return res + "_" + num;
    }

    public static char recover(String str, int index) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int sum = 0;
        int num = 0;
        boolean stage = true;
        char cur = 0;
        for (int i = 0; i < chars.length; i++) {
            cur = chars[i];
            if (chars[i] == '_') {
                stage = !stage;
            } else if (stage) {
                sum = sum + num;
                if (sum > index) {
                    return cur;
                }
                num = 0;
            } else {
                num = num * 10 + cur - '0';
            }
        }
        return sum > index ? cur : 0;
    }

    public static void main(String[] agrs) {
        System.out.println(recover("a_3_b_2_a_1_d_3_f_2_c_1", 5));
    }
}
