import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 4, 1 };
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1 - i;
            int index = findIndex(arr, last, 0);
            swap(index, last, arr);
        }
    }

    public static int findIndex(int[] arr, int end, int start) {
        // find largest
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void swap(int one, int last, int[] arr) {
        int temp = arr[last];
        arr[last] = arr[one];
        arr[one] = temp;
    }
}
