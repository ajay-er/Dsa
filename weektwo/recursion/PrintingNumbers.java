public class PrintingNumbers {
    public static void main(String[] args) {
          PrintNum(5);
    }

    private static void PrintNum(int n) {
        if (n <  1) {
            return;
        }
         PrintNum(n - 1);
        System.out.println("number --> " + n);
    }
}