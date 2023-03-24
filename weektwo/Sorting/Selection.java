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
            int indexMin = findIndex(arr, last);
            swap(last, indexMin, arr);
        }
    }

    private static void swap(int last, int indexMin, int[] arr) {
        int temp = arr[last];
        arr[last] = arr[indexMin];
        arr[indexMin] = temp;
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
}
