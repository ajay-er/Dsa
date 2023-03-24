import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = { -1, -2, 0, 3 };
        sortMerge(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortMerge(int[] arr) {

        int indexLength = arr.length;
        int midIndex = arr.length / 2;

        if (arr.length < 2) {
            return;
        }

        int[] left = new int[midIndex];
        int[] right = new int[indexLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            left[i] = arr[i];
        }

        for (int i = midIndex; i < indexLength; i++) {
            right[i - midIndex] = arr[i];
        }

        sortMerge(left);
        sortMerge(right);

        // merge
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] >= right[j]) {
                arr[k] = right[j];
                j++;
            } else {
                arr[k] = left[i];
                i++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }
}
