public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {3,5,6,2,35,7};
        int target = 2;
       System.out.println( range(arr,target,2,4));

    }
    public static int range(int[] arr,int target,int start,int end){
        for(int i=start;i<end;i++){
            if(target == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
