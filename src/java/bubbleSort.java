import java.util.Random;

public class bubbleSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i=0; i<array.length;i++){
            array[i] = random.nextInt(50);
            System.out.print(array[i] + " ");
        }
        for (int i=0; i<array.length-1;i++){
            for (int j=1; j<array.length -i-1;j++){
                if (array[j+1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println();
        for (int i: array)
        System.out.print(i + " ");
    }
}
