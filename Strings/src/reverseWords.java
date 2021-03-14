public class reverseWords {
    public static void reverseWord(char[] chars) {
        if (chars.length == 0 || chars == null) {
            return;
        }
        reverse(chars, 0, chars.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                l = (i == 0 || chars[i - 1] == ' ' ? i : l);
                r = (i == chars.length - 1 || chars[i + 1] == ' ' ? i : r);
            }
            if (l != -1 && r != -1) {
                reverse(chars, l, r);
                l = -1;
                r = -1;
            }
        }

    }

    public static void reverse(char[] chars, int start, int end) {
        if (chars.length == 0 || chars == null) {
            return;
        }
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        String test = "hello how are you";
        char[] re = test.toCharArray();
        reverseWord(re);
        System.out.println(re);
    }
}