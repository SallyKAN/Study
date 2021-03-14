/**
 * 给定 一个 有序 数组 arr， 调整 arr 使得 这个 数组 的 左 半部 分 没有 重复 元素 且 升序，
 * 而 不用 保证 右 部分 是否 有序。
 * 例如， arr=[ 1， 2， 2， 2， 3， 3， 4， 5， 6， 6， 7， 7， 8， 8， 8， 9]，
 * 调整 之后 arr=[ 1， 2， 3， 4， 5， 6， 7， 8， 9，…]。
 */
public class leftUnique {
    public static int[] leftUnique(int[] array) {
        if (array.length < 2 || array == null) {
            return array;
        }
        int u = 0;
        int i = 1;
        while (i != array.length) {
            if (array[i++] != array[u]) {
                swap(array, ++u, i - 1);
            }
        }
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
