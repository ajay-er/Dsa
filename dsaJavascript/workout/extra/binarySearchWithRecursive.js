function bsRecursion(arr, target, s, e) {
  if (s <= e) {
    let mid = Math.floor(s + e / 2);

    if (arr[mid] === target) return mid;

    if (arr[mid] > target) return bsRecursion(arr, target, s, mid - 1);
    if (arr[mid] < target) return bsRecursion(arr, target, mid + 1, e);
  }

  return -1;
}

let arr = [2, 5, 8, 9, 19, 23];

let b = bsRecursion(arr, 2, 0, arr.length - 1);

console.log(b);
