public class ProdDigits {
        public static void main(String[] args) {
            int ans = Prod(1232066);
            System.out.println(ans);
        }
    
        private static int Prod(int n) {
            if(n%10==n){
                return n;
            }
            return (n%10) * Prod(n/10);
        }
    
}
