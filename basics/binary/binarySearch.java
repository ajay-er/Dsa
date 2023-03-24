public class binarySearch {
    public static void main(String[] args) {
        // acending array
        int[] arr = { 1, 5, 6, 44, 65, 75, 81, 82, 992, 2939, 9999 };

        // desending array
        int[] arr1 = { 999, 898, 777, 666, 99, 77, 66, 55, 44, 33, 9, 7, 2, -1 };

        int target = 5;

        int ans = findNum(target, arr);

        System.out.println("index number of the target:- " + ans);
    }

    public static int findNum(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (arr[start] < arr[end]) {

                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {

                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}
