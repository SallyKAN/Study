public class getDeformation {
    public static boolean getResult(String str1, String str2) {
        if (str1 == null | str2 == null | str1.length() != str2.length()) {
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chars1.length; i++) {
            map[chars1[i]]++;
        }
        for (int j = 0; j < chars2.length; j++) {
            int count = chars2[j];
            count--;
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] agrs) {
//        String fir = "1234";
//        String sec = "43211";
//        System.out.println(getResult(fir,sec));
        String test = "A-1B--23";
        for (String s : test.split("\\D")){
            System.out.println(s);
        }
    }
}
