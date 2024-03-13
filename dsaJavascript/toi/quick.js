function quicksort(nums, start = 0, end = nums.length - 1) {
  if (start < end) {
    let pivotIndex = partition(nums, start, end);
    quicksort(nums, start, pivotIndex - 1);
    quicksort(nums, pivotIndex + 1, end);
  }
}

function partition(nums, start, end) {
  let pivot = nums[end];
  let left = start;
  let right = end - 1;

  while (left <= right) {
    while (nums[left] < pivot) {
      left++;
    }

    while (nums[right] > pivot) {
      right--;
    }
    if (left < right) swap(nums, left, right);
  }
  swap(nums, left, end);
  return left;
}

function swap(array, index1, index2) {
  let temp = array[index1];
  array[index1] = array[index2];
  array[index2] = temp;
}

let numbers = [];
for (let i = 0; i < 10; i++) {
  numbers.push(Math.floor(Math.random() * 100));
}

console.log("Before:", numbers);
quicksort(numbers);
console.log("After:", numbers);
