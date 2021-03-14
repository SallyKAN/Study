public class replaceString {
    public static String replace(char[] chars) {
        if (chars.length == 0 | chars == null) {
            return null;
        }
        int num = 0; // number of spaces;
        int len = 0; // size of left
        for (; len < chars.length - 1 && chars[len] != 0; len++) {
            if (chars[len] == ' ') {
                num++;
            }
        }
        int size = chars.length + 2 * num; // new length of string
        for (int j = len - 1; j >= 0; j--) {
            if (chars[j] == ' '){
                chars[size--] =  '0';
                chars[size--] = '2';
                chars[size--]='%';
            }else {
                chars[size--] = chars[j];
            }
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args){
        String test = "a b c";
//        System.out.println(replace(test));
    }
}
