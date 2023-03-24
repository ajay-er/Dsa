import java.util.Arrays;

public class QucikSort2 {
    public static void main(String[] args) {
        int[] arr = { 5,1 ,2,5,1,8,1};
        int l = 0;
        int h = arr.length - 1;
        sortQuick(arr, l, h);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortQuick(int[] arr, int low, int high) {
        
        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int m = e;
        int pivot = arr[m];

       

        while (s <= e) {
            while (pivot > arr[s]) {
                s++;
            }

            while (pivot < arr[e]) {
                e--;
            }

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                e--;
                s++;
            }
        }
        
        sortQuick(arr,low,e);
        sortQuick(arr,s,high);

    }
}
