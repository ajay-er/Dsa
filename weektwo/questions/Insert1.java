package questions;

import java.util.Arrays;

//Given an array of integers nums, sort the array in ascending order using Insertion Sort.
// Input: [4, 2, 1, 3]
// Output: [1, 2, 3, 4]
public class Insert1 {

    public static void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] nums = { 4, 2, 1, 3 };
        insertionSort(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 2, 3, 4]
    }

}