public class CountZeroInNumber {
    public static void main(String[] args) {
        int c = 0;
        System.out.println(TakeCount(23000018, c));
    }

    private static int TakeCount(int n, int c) {
        if (n == 0) {
            return c;
        }
        int rem = n % 10;
        if (rem == 0) {
            c++;
        }
        return TakeCount(n / 10, c);
    }
}
