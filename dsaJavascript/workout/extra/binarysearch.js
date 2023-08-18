function binarySearch(arr, target) {
  if (!arr.length) {
    return -1;
  }

  let s = 0;
  let e = arr.length - 1;

  while (s <= e) {
    let mid = Math.floor(s + (e - s) / 2);

    if (arr[mid] === target) {
      return mid;
    }

    if (arr[mid] < target) {
      s = mid + 1;
    }

    if (arr[mid] > target) {
      e = mid - 1;
    }
  }

  return -1;
}

let arr = [2, 3, 9, 29, 33, 99];
let index = binarySearch(arr, 99);

console.log(index);
