import java.util.Arrays;

import org.w3c.dom.Node;

// import java.util.Arrays;

// public class temp {
//     public static void main(String[] args) {
//         int[] arr ={ 3,5,6};
//         int[] arr1 = new int[4];
//         int j =0;
//         for (int i = 0; i < arr.length; i++) {
//             arr1[j]=arr[i];
//             j++;
//         }
//         int ins = arr.length;
//        arr1[3]= 33;
//     }
// }

// public class temp{
//     public static void main(String[] args) {
//         int[ ] arr = {0,0,2,0,3,0};
//         int temp;
//         int j = 0;
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] == 0) {
//                  temp = arr[j];
//                 arr[j] = arr[i];
//                 arr[i] = temp;
//                 j++;
//             }
//         }
//         System.out.println(Arrays.toString(arr));
//     }
// }

// public class temp {
//     public static void main(String[] args) {
//          int[] arr = { 1,0,2,0,0,3};
//          int temp ;
//          int j =0;
//          for (int i = 0; i < arr.length; i++) {
//             if(arr[i] != 0){
//                 temp =arr[j];
//                 arr[j] = arr[i];
//                 arr[i] = temp;
//                 j++;
//             }
//          }
//          System.out.println(Arrays.toString(arr));
//     }
// }

// public class temp {
//     public static void main(String[] args) {
//         int[] arr = { 3, 1,6,-2,13};
//         bubble(arr);
//         System.out.println(Arrays.toString(arr));
//     }

//     public static void bubble(int[] arr) {
//         int temp;
//         boolean isAs = false;
//         for (int i = 0; i < arr.length ; i++) {
//             for (int j = 1; j < arr.length-i; j++) {
//                 if (arr[j] < arr[j - 1]) {
//                     temp = arr[j];
//                     arr[j] = arr[j - 1];
//                     arr[j - 1] = temp;
//                     isAs = true;
//                 }
//             }
//             if(!isAs){
//                 break;
//             }
//         }
//     }
// }

// public class temp {
//     public static void main(String[] args) {
//         int[] arr = { 3, 5, 4, 2, 1 };
//         selection(arr);
//         System.out.println(Arrays.toString(arr));
//     }

//     public static void selection(int[] arr) {

//         for (int i = 0; i < arr.length; i++) {
//             int end = arr.length - i - 1;
//             int max = getIndex(arr, end, 0);
//             swap(max,arr,end);
//         }
//     }

//     public static int getIndex(int[] arr, int end, int start) {
//         int max = start;
//         for (int i = start; i <= end; i++) {
//             if (arr[max] < arr[i]) {
//                 max = i;
//             }
//         }
//         return max ;
//     }

//     public static void swap(int max,int[] arr,int end){
//         int temp = arr[max];
//         arr[max] = arr[end];
//         arr[end] = temp; 
//     }

// }



// public class temp {
//     public static void main(String[] args) {
//         int[] arr = {3,2,5,1,9,0};
//         insertion(arr);
//         System.out.println(Arrays.toString(arr));
//     }

//     public static void insertion(int[] arr){
//         for (int i = 0; i < arr.length-1; i++) {
//             for (int j = i+1; j > 0 ; j--) {
//                     if(arr[j]<arr[j-1]){
//                         swap(j,arr,j-1);
//                     }else{
//                         break;
//                     }
//             }
//         }
//     }

//     public static void swap(int max,int[] arr,int end){
//                 int temp = arr[max];
//                 arr[max] = arr[end];
//                 arr[end] = temp; 
//             }
        
// }


public class temp{
    public static void main(String[] args) {
        
    }
}

