import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 1,22,5 };
        sortI(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortI(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(j-1,j,arr);
                }else{
                    break;
                }
            }
        }
    }

    private static void swap(int s, int j, int[] arr) {
        int temp = arr[s];
        arr[s] = arr[j];
        arr[j] = temp;
    }
}
