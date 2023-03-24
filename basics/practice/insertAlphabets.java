package practice;

import java.util.Arrays;
import java.util.Scanner;

public class insertAlphabets {

    public static void main(String[] args) {
        
        String name ="Ajay";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a charater to insert b/w "+name);
        char newChar = s.next().charAt(0);
        System.out.println("Enter the postion");
        int index = s.nextInt();
        insert(name,index-1,newChar);
    }

    public static void insert(String name,int index,char charcter ){
        char[] cArr = name.toCharArray();
        char[] arr =new char[cArr.length+1];
        int j=0;
        if(index>arr.length){
            System.out.println("Not that position");
            return;
        }
        
        if(index==cArr.length-1){
            arr[index] = charcter; 
        }
     
        for (int i = 0; i < cArr.length; i++) {
            if(i==index){
                arr[j]=charcter;
                j++;
            }
            arr[j++] = cArr[i];
        
     }

     if(index==j){
        arr[j]=charcter;
     }
     System.out.println(Arrays.toString(arr));
    }
}
