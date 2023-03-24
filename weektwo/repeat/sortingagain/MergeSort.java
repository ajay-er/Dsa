package repeat.sortingagain;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr= {2,5,1,3,4};
        merge(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void merge(int[] arr) {
    
        int totalSize = arr.length;
        int mid = totalSize/2;

        if(totalSize<2){
            return;
        }

        int[] left = new int[mid];
        int[] right = new int[totalSize-mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < totalSize; i++) {
            right[i-mid] = arr[i];
        }

        merge(left);
        merge(right);

        mergeShift(arr,left,right);
    }

    private static void mergeShift(int[] arr, int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0 , j = 0 , k = 0 ;
        while(leftLength > i && rightLength > j){
            if(left[i]<right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(leftLength>i){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(rightLength>j){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
