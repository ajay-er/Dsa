package repeat.sortingagain;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 1, 2, 5 };
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];

        while (s <= e) {
            while (pivot > arr[s]) {
                s++;
            }

            while (pivot < arr[e]) {
                e--;
            }

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        quick(arr, s, high);
        quick(arr, low, e);
    }
}
