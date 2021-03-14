import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sortList_yourshittyanswer {

    private static int[] aux;

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> listNodes = new ArrayList<>();
        while (head.next != null) {
            listNodes.add(head.val);
            head = head.next;
        }
        int[] values = new int[listNodes.size()];
        for (int i = 0; i < listNodes.size(); i++) {
            values[i] = listNodes.get(i);
        }
        mergeSort(values);
        ListNode res = null;
        for (int i : values) {
            ListNode node = new ListNode(i);
            res.next = node;
            res = res.next;
        }
        return res.next;
    }

    public static void mergeSort(int[] array) {
        aux = new int[array.length];
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int start, int end) {
//        int start = 0;
//        int end = array.length - 1;

        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    public static void merge(int[] array, int start, int middle, int end) {
        for (int k = start; k <= end; k++) {
            aux[k] = array[k];
        }
        int i = start;
        int j = middle + 1;
        for (int k = start; k <= end; k++) {
            if (i > middle) {
                array[k] = aux[j++];
            } else if (j > end) {
                array[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 5, 4, 1, 10, 9, 8};
//        mergeSort(test);
//        for (int i : test) {
//            System.out.println(i);
//        }


    }
}
