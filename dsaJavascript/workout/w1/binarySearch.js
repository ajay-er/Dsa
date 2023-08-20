function binarySearch(arr, target) {
  if (!arr.length) return;

  let s = 0;
  let e = arr.length - 1;

  while (s <= e) {
    let mid = Math.floor(s + (e - s) / 2);
    if (target === arr[mid]) {
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
let arr = [2, 3, 5, 9, 19, 29];
let index = binarySearch(arr, 19);
console.log(index);
