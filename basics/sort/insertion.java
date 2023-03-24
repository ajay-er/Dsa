import java.util.Arrays;

public class insertion {
    public static void main(String[] args) {
        int[] arr = {3,2,6,1};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertion(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    swap(j,j-1,arr);
                }else{
                    break;
                }
            }
        }
    }

    public static void swap(int one, int last, int[] arr) {
        int temp = arr[last];
        arr[last] = arr[one];
        arr[one] = temp;
    }
}

