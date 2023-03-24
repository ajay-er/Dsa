package revise.sorting;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 3 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int max = findIndex(arr, last);
            swap(arr, last, max);
        }
    }

    private static int findIndex(int[] arr, int last) {
        int max = 0;
        for (int i = 0; i <= last; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
