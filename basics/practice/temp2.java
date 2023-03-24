package practice;

import java.util.Arrays;
import java.util.Scanner;

public class temp2 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int[] newArray = new int[array.length * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array.length; j++) {
                newArray[i * array.length + j] = array[j];
            }
        }

       System.out.println(Arrays.toString(newArray));
    }
}
