function merge(nums) {
  if (nums.length <= 1) {
    return nums;
  }
  let start = 0;
  let end = nums.length;
  let mid = Math.floor((start + end) / 2);
  let left = nums.slice(0, mid);
  let right = nums.slice(mid);

  return recurseSort(merge(left), merge(right));
}

function recurseSort(left, right) {
  let i = 0;
  let j = 0;
  let result = [];
  while (left.length > i && right.length > j) {
    if (left[i] > right[j]) {
      result.push(right[j]);
      j++;
    }

    if (left[i] < right[j]) {
      result.push(left[i]);
      i++;
    }
  }

  while (left.length > i) {
    result.push(left[i]);
    i++;
  }

  while (right.length > j) {
    result.push(right[j]);
    j++;
  }
  return result;
}

let nums = [119, 22, 12, 9, 11, 2];

nums = merge(nums);

console.log(nums);
