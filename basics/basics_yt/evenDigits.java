//Given an array nums of integers, return how many of them contain an even number of digits.

public class evenDigits {
    public static void main(String[] args) {
        int[] arr = { 3, 55, 224, 643436, 777, 23437 };
        System.out.println("count of even numbers " + findNumbers(arr));
        System.out.println(digit2(-833));// finding the digits
    }

    public static int findNumbers(int[] arr) {
        int c = 0;
        for (int element : arr) {
            if (even(element)) {
                c++;
            }
        }
        return c;

    }

    public static boolean even(int num) {
        int digitsCount = evenDigit(num);
        return digitsCount % 2 == 0;
    }

    public static int evenDigit(int num) {
        if (num < 0) {
            num = num * -1;
        }

        if (num == 0) {
            return 1;
        }

        int c = 0;
        while (num > 0) {
            num = num / 10;
            c++;
        }
        return c;
    }




    public static int digit2(int num) {
        if (num < 0) {
            num = num * -1;
        }

        return (int) (Math.log10(num) + 1);
    }

}
