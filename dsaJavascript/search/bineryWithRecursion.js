function binarySearch(arr, start, end, target) {
  if (start <= end) {
    let mid = Math.floor(start + (end - start) / 2);

    if (arr[mid] === target) {
      return mid;
    }

    if (arr[mid] < target) {
      return binarySearch(arr, mid + 1, end, target);
    } else {
      return binarySearch(arr, start, mid - 1, target);
    }
  } else {
    return -1;
  }
}

let arr = [6, 8, 23, 24, 29, 39, 51, 90];

let ans = binarySearch(arr, 0, arr.length - 1, 6);

console.log(ans);
