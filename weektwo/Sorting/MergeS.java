import java.util.Arrays;

public class MergeS {
    public static void main(String[] args) {
        int[] arr = { -23,5,0,2 };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int totalIndex = arr.length;
        int mid = totalIndex / 2;

        if (totalIndex < 2) {
            return;
        }

        int[] left = new int[mid];
        int[] right = new int[totalIndex - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < totalIndex; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {

        int leftLength = left.length;
        int rightLength = right.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && rightLength > j) {

            if (left[i] > right[j]) {
                arr[k] = right[j];
                j++;
            } else {
                arr[k] = left[i];
                i++;
            }
            k++;

        }

        while (i < leftLength) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

}
