import java.util.Arrays;

public class Cycle {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        cycle(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cycle(int[] arr){
        int index;
        for (int i = 0; i < arr.length; i++) {
            index = arr[i] - 1 ;
            if(arr[i]!=index){
                swap(i,index,arr);
            }   
        }
    }

    public static void swap(int i,int index,int[] arr){
                        int temp = arr[i];
                        arr[i] = arr[index];
                        arr[index] = temp; 
                    }
}
