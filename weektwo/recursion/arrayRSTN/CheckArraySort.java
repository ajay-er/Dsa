package arrayRSTN;

public class CheckArraySort {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 5, 8, 9 };
        System.out.println(Sorted(arr, 0));
    }

    private static boolean Sorted(int[] arr, int index) {

        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && Sorted(arr, index + 1);
    }

}
