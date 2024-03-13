function insertion(nums) {
  for (let i = 1; i < nums.length; i++) {
    for (let j = i; j >= 1; j--) {
      if (nums[j] < nums[j - 1]) {
        swap(nums, j, j - 1);
      } else {
        break;
      }
    }
  }
}

function swap(nums, i, j) {
  let temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}

let nums = [119, 22, 12, 9, 11, 2];

insertion(nums);

console.log(nums);
