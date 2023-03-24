public class temp {
    public static void main(String[] args) {
        int[] arr = { 3, 15, 26, 37, 66, 78, 89, 98, 99, 101 };
        int target = 102;
        int ans = ceiling(arr, target);
        System.out.println(ans);
    }

    public static int ceiling(int[] arr,int target){
        int start = 0;
        int end = arr.length-1; 
        boolean isAs = arr[start] < arr[end];
        while(start<=end){
            int mid = start + (end-start)/2;

            if(target == arr[mid]){
                return arr[mid];
            }

            if(target>arr[arr.length-1]){
                return -1;
            }

            if(isAs){
                if(target < arr[mid]){
                    end = mid - 1 ;
                }else{
                    start = mid + 1 ;
                }
            }else{
                if(target > arr[mid]){
                    end = mid - 1 ;
                }else{
                    start = mid + 1 ;
                }
            }
        }
        return arr[start];
    }
}


