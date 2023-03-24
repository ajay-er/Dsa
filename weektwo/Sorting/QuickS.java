import java.util.Arrays;

public class QuickS {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 4, 5 };
        int low = 0;
        int high = arr.length - 1;
        quick(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick(int[] arr, int low, int high) {
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = arr[m];

        if (low >= high) {
            return;
        }

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
        quick(arr, low, e);
        quick(arr, s, high);
    }
}