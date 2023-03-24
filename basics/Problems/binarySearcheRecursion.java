    import java.lang.annotation.Target;

    public class binarySearcheRecursion {
        public static void main(String[] args) {
            int[] arr = { 1,5,7,8,9,22,99,923,1901 };
            int target = 8;
            int index = search(arr, target, 0, arr.length - 1);
            System.out.println(index);
        }

        public static int search(int[] arr, int target, int s, int e) {

            if (s > e) {
                return -1;
            }

            int mid = s + (e - s) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                return search(arr, target, s, mid - 1);
            }

            return search(arr, target, mid + 1 , e);
        }
    }