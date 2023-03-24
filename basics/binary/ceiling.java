public class ceiling {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 6, 7, 8, 9, 10, 12, 135, 333, 444, 909 };
        int target = 1;
        int ans = findCeiling(arr, target);
        System.out.println("found ceiling :  " + ans);
    }

    public static int findCeiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[arr.length - 1]) {
                return -1;
            }
            
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return arr[start];
    }
}
