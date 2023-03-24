import java.util.Scanner;

public class currencyToUSD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter rupees");
        float ind =s.nextInt();
        double usd = ind/82;
        System.out.println(ind+" is "+usd+" dollar");
    }
}
