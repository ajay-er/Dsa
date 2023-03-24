package questions;

import java.util.Arrays;

// Given an array of integers nums, sort the array in descending order using Selection Sort.

// input: [4, 2, 1, 3]
// Output: [4, 3, 2, 1]

public class Selection {
    public static void selectionSortDesc(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 1, 3 };
        selectionSortDesc(nums);
        System.out.println(Arrays.toString(nums));
    }

}
