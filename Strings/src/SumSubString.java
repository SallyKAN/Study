public class SumSubString {
    public static int getSum(String s) {
        String temp = "";
        int sum = 0;
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (Character.isDigit(ss[i])) {
                if (i > 0 && ss[i - 1] == '-') {

                }
                temp += ss[i];
            } else {
                if (!temp.isEmpty()) {
                    sum += Integer.parseInt(temp);
                }
                temp = "0";
            }
        }
        return sum + Integer.parseInt(temp);
    }

    public static void main(String[] args) {
//        String[] tests = {"-1abc23", "geeks4geeks", "1abc2x30yz67", "123abc"};
//        for (String test : tests) {
//            System.out.println(getSum(test));
//        }
//        System.out.println(Integer.parseInt("--1")+2);
        String test = "abcd";
        char[] chars = test.toCharArray();
        chars[test.length() - 2] = 0;
        System.out.println(String.valueOf(chars));
    }
}
