public class FactorialOfNumber {
    public static void main(String[] args) {
        // int s = factorial(1);
        // System.out.println(s);

        int ans = sum(5);
        System.out.println(ans);
    }

    private static int factorial(int n) {

        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static int sum(int n) {

        if (n <= 1) {
            return 1;
        }
        return n + sum(n - 1);
    }


}
