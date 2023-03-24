package questions;

import java.util.Arrays;

public class Selec {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 4, 1, 3 };
        sortS(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortS(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int index = findIndex(arr, last);

            swap(arr, index, last);
        }
    }

    private static void swap(int[] arr, int index, int last) {
        int temp = arr[index];
        arr[index] = arr[last];
        arr[last] = temp;
    }

    private static int findIndex(int[] arr, int last) {
        int max = 0;
        for (int j = 0; j <= last; j++) {
            if (arr[max] < arr[j]) {
                max = j;
            }
        }
        return max;
    }
}
