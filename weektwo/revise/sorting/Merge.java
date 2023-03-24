package revise.sorting;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 5, 4 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int totalLength = arr.length;
        int mid = totalLength / 2;

        if (totalLength < 2) {
            return;
        }

        int left[] = new int[mid];
        int right[] = new int[totalLength - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < totalLength; i++) {
            right[i - mid] = arr[i];
        }

        sort(left);
        sort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;
        while (leftLength > i && rightLength > j) {
            if (left[i] > right[j]) {
                arr[k] = right[j];
                j++;
            } else {
                arr[k] = left[i];
                i++;
            }
            k++;
        }

        while (leftLength > i) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (rightLength > j) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
