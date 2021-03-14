public class minDistance {
    public static int minDistance(String[] strings, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            if (str1.equals(strings[i])) {
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if (str2.equals(strings[i])) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public static void main(String[] agrs){
        String[] strings = new String[]{"1","4","3","3","1","2","7"};
        System.out.println(minDistance(strings,"1","2"));
    }
}
