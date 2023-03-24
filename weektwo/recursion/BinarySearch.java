public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 8, 99, 910, 9183 };
        int target = 5;
        int s = 0;
        int e = arr.length - 1;
        int ans = BnSearch(target, arr, s, e);
        System.out.println(ans);
    }

    private static int BnSearch(int target, int[] arr, int s, int e) {

        int mid = s + (e - s) / 2;

        if (s > e) {
            return -1;
        }

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return BnSearch(target, arr, s, e = mid - 1);
        }

        return BnSearch(target, arr, s = mid + 1, e);

    }
}