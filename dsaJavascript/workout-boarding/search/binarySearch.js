function binarySearch(arr, target) {
  let start = 0;

  let end = arr.length - 1;

  while (start <= end) {
    let mid = Math.floor(start + (end - start) / 2);

    if (arr[mid] === target) return mid;

    if (arr[mid] > target) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }

  return -1;
}

let arr = [6, 8, 23, 24, 29, 39, 51, 90];

let ans = binarySearch(arr, 8);

console.log(ans);
