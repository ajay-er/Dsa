import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 1, 5 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(j, j - 1, arr);
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int j, int j2, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[j2];
        arr[j2] = temp;
    }
}
