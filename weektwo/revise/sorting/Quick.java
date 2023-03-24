package revise.sorting;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr={5,52,4,3,1};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int low, int high) {
        if(low>=high){
            return;
        }

        int s = low;
        int e = high;
        int m = s+(e-s)/2;
        int pivot = arr[m];

        while(s<=e){
            while(pivot>arr[s]){
                s++;
            }

            while(pivot < arr[e]){
                e--;
            }

            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                e--;
                s++;
            }
        }

        sort(arr, s, high);
        sort(arr, low, e);
    }
}
