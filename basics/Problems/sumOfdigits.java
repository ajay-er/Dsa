public class sumOfdigits {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(sum(x));
    }
    
    public static int sum(int x){
        if(x<=1){
         return 1;
        }   
        return x + sum(x-1);
    }
}
