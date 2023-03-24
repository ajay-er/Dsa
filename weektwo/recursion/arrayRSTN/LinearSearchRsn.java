package arrayRSTN;

import java.util.ArrayList;

public class LinearSearchRsn {
    public static void main(String[] args) {
        int[] arr = { 2, 93,3, 34,3, 9, 3};
        int target = 3;
        int sIndext = 0;
        
        System.out.println(linearS(arr, target, sIndext));

        System.out.println(linearSlist(arr, target, sIndext, new ArrayList<Integer>()));

        System.out.println(linearSlistIn(arr,target,sIndext));
        
    }
    //my way
    // private static int linearS(int[] arr, int target, int index) {

    //     if (target == arr[index]) {
    //         return index;
    //     }

    //     if (arr.length-1 == index) {
    //         return -1;
    //     }

    //     return  linearS(arr, target, index+1);

    // }


    //more optimised way boolear return 
    public static boolean linearS(int[] arr,int target,int index){
        if(arr.length==index){
            return false;
        }
        return arr[index]==target || linearS(arr, target, index+1);
    }
    
    

    // static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<Integer> linearSlist(int[] arr, int target, int Index,ArrayList<Integer> list) {
        
        if(arr.length==Index){
            return list;
        }
        if(target==arr[Index]){
            list.add(Index);
            // return list;
        }
        return linearSlist(arr, target, Index+1, list);
    }




    //creating object again and again(not recomended)
    private static ArrayList<Integer> linearSlistIn(int[] arr, int target, int Index) {
         ArrayList<Integer> list = new ArrayList<>();
        if(arr.length==Index){
            return list;
        }
        if(target==arr[Index]){
            list.add(Index);
        }
        ArrayList<Integer> ansFromBelowCalls =  linearSlistIn(arr, target, Index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}

