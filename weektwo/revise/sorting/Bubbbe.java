package revise.sorting;

import java.util.Arrays;

public class Bubbbe {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 3 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        boolean sorted;
        for (int i = 0; i < arr.length; i++) {
            sorted = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                    sorted = true;
                }
            }
            if (!sorted) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
