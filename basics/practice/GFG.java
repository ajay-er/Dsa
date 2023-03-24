package practice;

import java.util.Arrays;

class GfG
{
	public static void palinArray(int[] a, int n)
           {
               String str = Arrays.toString(a);
                System.out.println(str);                  
           }

           public static void main(String[] args) {
                int[] a= {3,42,34,9};
                palinArray(a, 4);
           }
}