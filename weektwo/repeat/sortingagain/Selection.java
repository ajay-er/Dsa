package repeat.sortingagain;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 4, 1, 3 };
        // selec(arr);
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insert(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private static void selec(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = findIndex(arr, i);
            swap(arr, minIndex, i);
        }
    }

    private static void swap(int[] arr, int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    private static int findIndex(int[] arr, int k) {
        int min = k;
        for (int i = k; i < arr.length; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        return min;
    }
}
