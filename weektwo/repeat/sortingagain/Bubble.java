package repeat.sortingagain;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 4, 1, 3 };
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubble(int[] arr) {
        boolean swaped;
        for (int i = 0; i < arr.length; i++) {
            swaped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swaped = true;
                }
            }
            if (!swaped) {
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
