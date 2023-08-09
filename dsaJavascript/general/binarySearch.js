function binarySearch(arr, target) {
  let s = 0;
  let e = arr.length - 1;

  while (s <= e) {
    let mid = Math.floor(s + (e - s) / 2);

    if (arr[mid] === target) {
      return mid;
    }

    if (target > arr[mid]) {
      s = mid + 1;
    }

    if (target < arr[mid]) {
      e = mid - 1;
    }
  }

  return -1;
}

let result = binarySearch([1, 2, 5], 5);

console.log(result);
