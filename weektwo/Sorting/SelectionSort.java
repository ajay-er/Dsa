import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1,3,5,4,2 };
        sortS(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortS(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - 1 - i;
            int maxIndex = findIndex(arr, last);
            swap(maxIndex, last, arr);
        }
    }

    private static int findIndex(int[] arr, int last) {
        int max = 0;
        for (int i = 0; i <=last; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(int maxIndex, int last, int[] arr) {
        int temp = arr[last];
        arr[last] = arr[maxIndex];
        arr[maxIndex] = temp;
    }
}
