package repeat;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortingP {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 4, 3 };
        // bubble(arr);
        // selectionS(arr);
        // insertS(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void insertS(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j>0; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }else{
                    break;
                }
            }
        }
    }

    private static void selectionS(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
                int last = arr.length-i-1;
                int indexMax = findMaxIndex(arr,last);
                swap(arr, last, indexMax);
        }

    }

    private static int findMaxIndex(int[] arr,int last) {
        int max = 0;
        for (int i = 0; i <=last; i++) {
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }

    private static void bubble(int[] arr) {
        boolean sorted;
        for (int i = 0; i < arr.length; i++) {
            sorted = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                    sorted = true;
                }
            }
            if(!sorted){
                break;
            }
        }
    }






    // swap
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
