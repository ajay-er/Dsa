function quick(nums, low = 0, high = nums.length - 1) {
  if (low < high) {
    let partionIndex = partion(nums, low, high);
    quick(nums, low, partionIndex - 1);
    quick(nums, partionIndex + 1, high);
  }
}

function partion(nums, low, high) {
  let pivot = nums[high];

  let lp = low;
  let rp = high - 1;

  while (lp <= rp) {
    while (nums[lp] < pivot) {
      lp++;
    }
    while (nums[rp] > pivot) {
      rp--;
    }
    if (lp < rp) {
      swap(nums, rp, lp);
      rp--
      lp++
    }
  }
  swap(nums,lp,high)
  return lp;
}

function swap(nums, i, j) {
  let temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}


let numbers = [];
for (let i = 0; i < 10; i++) {
  numbers.push(Math.floor(Math.random() * 100));
}

console.log("Before:", numbers);
quick(numbers);
console.log("After:", numbers);
