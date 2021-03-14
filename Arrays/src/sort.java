public class sort {
    public static void sort(int[] array) {
        if (array.length == 0 || array == null) {
            return;
        }
        int temp = 0;
        int next = 0;
        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            while (array[i] != i + 1) {
                next = array[temp - 1];
                array[temp - 1] = temp;
                temp = next;
            }
        }
        for (int i:array){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,5,4,3};
        sort(test);
    }
}
