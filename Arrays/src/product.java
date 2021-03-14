/**
 * 给定 一个 整型 数组 arr， 返回 不 包含 本 位置 值 的 累 乘数 组。
 * 例如， arr=[ 2， 3， 1， 4]， 返回[ 12， 8， 24， 6]， 即 除 自己 外， 其他 位置 上 的 累 乘。
 */
public class product {
    public static int[] product(int[] array) {
        if (array.length < 2 || array == null) {
            return null;
        }
        int[] res = new int[array.length];
        int count = 0;
        int allProduct = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                allProduct *= array[i];
            } else {
                count++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (count == 0){
                res[i] = allProduct/array[i];
            }
            if (count == 1){
                if (array[i] == 0){
                    res[i] = allProduct;
                }
            }
        }
        return res;
    }
}
