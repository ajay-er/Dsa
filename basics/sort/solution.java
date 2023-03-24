import java.util.Arrays;

class solution {
    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int index = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[index]) {
                swap(i, index, nums);
            } else {
                i++;
            }
        }
        // check for the missing number
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }

        return nums.length;

    }

    public static void swap(int max, int end, int[] arr) {
        int temp = arr[max];
        arr[max] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 4 };
        System.out.println(missingNumber(arr));
    }
}