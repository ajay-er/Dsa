import java.util.Scanner;

public class greeting {
    public static void main(String[] args) {
        System.out.println("Enter your name ");
        Scanner s =new Scanner(System.in);
        String name=s.next();
        System.out.println("Have a good day "+name);
    }
}
