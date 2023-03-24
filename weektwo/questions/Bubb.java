package questions;

import java.util.Arrays;

public class Bubb {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        sortB(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortB(int[] arr) {
        boolean swap;
        for (int i = 0; i < arr.length; i++) {
            swap = false;
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }

    
}
