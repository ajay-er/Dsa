package repeat;

import java.util.Arrays;

public class Merg {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 2, 4 };
        mergeS(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeS(int[] arr) {
        int totalSize = arr.length;
        int mid = arr.length / 2;

        if (totalSize < 2) {
            return;
        }

        int[] left = new int[mid];
        int[] right = new int[totalSize - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < totalSize; i++) {
            right[i - mid] = arr[i];
        }

        //recursion
        mergeS(left);
        mergeS(right);

        sort(arr,left,right);
    }

    private static void sort(int[] arr, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;

        int i=0,j=0,k=0;
        while(leftSize>i && rightSize > j){

            if(left[i]<right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(leftSize > i){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(rightSize > j){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
