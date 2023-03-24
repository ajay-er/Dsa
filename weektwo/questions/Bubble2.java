package questions;


//Given an array of integers nums, determine if the array is sorted in ascending order using Bubble Sort.
// Input: nums = [1, 2, 3, 4]
// Output: true
public class Bubble2 {
    public static boolean isSorted(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        boolean isSorted = isSorted(nums);
        System.out.println(isSorted); // Output: true
    }
   
    
}
