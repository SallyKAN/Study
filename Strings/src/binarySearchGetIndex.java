public class binarySearchGetIndex {
    //TODO
    public static int getIndex(String[] source, String str) {
        if (source == null || source.length == 0 || str == null) {
            return -1;
        }
        int left = 0;
        int right = source.length - 1;
        int middle = 0;
        int i = 0;
        int res = 0;
        while (left < right) {
            middle = (left + right) >> 1;
            if (source[middle] != null) {
                if (str.compareTo(source[middle]) < 0) right = middle - 1;
                else if (str.compareTo(source[middle]) > 0) left = middle + 1;
                else return middle;
            }
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String one = null;
        String two = null;
        System.out.println(one.equals(two));
    }

}
