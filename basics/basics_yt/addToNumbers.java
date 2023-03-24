import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

public class addToNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter two number");
        int a = s.nextInt();
        int b= s.nextInt();
        sum(a,b);
    }


     public static void sum(int a, int b){
        System.out.println("sum:"+(a+b));
    }
}