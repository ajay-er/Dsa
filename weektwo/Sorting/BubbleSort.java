import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {-2,0,3,2 };
        sortB(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortB(int[] arr) {
        boolean swaped;
        for (int i = 0; i < arr.length; i++) {
            swaped = false;
            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swaped = true;
                }
            }
            if(!swaped){
                break;
            }
        }
    }
}