package questions;


//Given an array of integers nums, find the kth smallest element in the array using Bubble Sort.
//nums = [4, 2, 1, 3], k = 2
// Output: 2

public class Bubble {
    public static void main(String[] args) {
        // Example usage:
        int[] nums = { 4, 2, 1, 3 };
        int k = 2;
        int kthSmallest = findKthSmallest(nums, k);
        System.out.println(kthSmallest); // Output: 2
    }

    public static int findKthSmallest(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (i == k - 1) {
                return nums[i];
            }
        }
        return nums[k - 1];
    }

}
