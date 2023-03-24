import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 5,1,2,4,3 };
        quickS(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickS(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = arr[m];

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
        quickS(arr, low, e);
        quickS(arr, s, high);

    }
}
