public class SumOfDigits {
    public static void main(String[] args) {
        int ans = digitsSum(123);
        System.out.println(ans);
    }

    private static int digitsSum(int n) {
        if(n==0){
            return n;
        }
        return (n%10) + digitsSum(n/10);
    }
}
