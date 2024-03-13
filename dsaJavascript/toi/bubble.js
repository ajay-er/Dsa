function bubble(nums) {
  for (let i = 0; i < nums.length - 1 ; i++) {
    let swapped = false;
    for (let j = 0; j < nums.length - i - 1; j++) {
      if (nums[j] > nums[j + 1]) {
        swap(nums, j, j + 1);
        swapped = true;
      }
    }
    if (!swapped) break;
  }
}

function swap(nums, i, j) {
  let temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}

let nums = [119, 22, 12, 9, 11, 2];

bubble(nums);

console.log(nums);
