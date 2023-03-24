public class minimumNum {
    public static void main(String[] args) {
        int[] arr = {3,5,11,34,23,6,-5};
        
        System.out.println(min(arr));
    }

    public static int min(int[] arr){
        if(arr.length ==0){
            return -1;
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
