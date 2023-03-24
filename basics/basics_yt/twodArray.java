import java.util.Arrays;

public class twodArray {
    public static void main(String[] args) {
        int [][] arr= {
            {1,3},
            {334,5,6},
            {3},
            {4,6,1,3,66}
        };
        int target = 334;
        int [] ans =search(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] search(int[][] arr,int tar){
        for (int i = 0; i < arr.length; i++) {
            for(int col= 0;col<arr[i].length;col++){
                if(tar == arr[i][col]){
                    return new int[]{i,col};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
