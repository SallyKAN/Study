public class substituteString {
    public static String substituteString(String str, String from, String to) {
        if (str == null || str.equals("") || from == null || from.equals("")) {
            return null;
        }
        int match = 0;
        char[] charstr = str.toCharArray();
        char[] charfrom = from.toCharArray();
        for (int i = 0; i < charstr.length; i++) {
            if (charstr[i] == charfrom[match++]) {
                if (match == charfrom.length) {
                    int n = match;
                    while (n > 0) {
                        charstr[i--] = 0;
                        n--;
                    }
                    match = 0;
                }
            } else {
                match = 0;
            }
        }
        String cur = "";
        String res = "";
        for (int i = 0; i < charstr.length; i++) {
            if (charstr[i] != 0) {
                cur = cur + String.valueOf(charstr[i]);
            }
            if (charstr[i] == 0 && (charstr[i - 1] != 0 || i == 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        if (cur != "") {
            res = res + cur;
        }

        return res;
    }

    public static void main(String[] args) {
//        char[] test = "abcdefg".toCharArray();
//        int n = 3;
//        int last = test.length - 1;
//        while (n > 0) {
//            test[last--] = 0;
//            n--;
//        }
        System.out.println(substituteString("123","abc","456"));
    }
}
