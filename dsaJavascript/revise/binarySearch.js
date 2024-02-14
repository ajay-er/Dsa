function binarySearch(arr, target) {
  if (arr.length < 1) {
    return -1;
  }

  let start = 0;
  let end = arr.length - 1;

  while (start <= end) {
    let mid = Math.floor(start + (end - start) / 2);

    if (arr[mid] === target) {
      return mid;
    }

    if (arr[mid] > target) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }

  return -1;
}

function binarySearchRecursion(arr, start, end, target) {
  if (arr.length < 1 || start > end) {
    return -1;
  }

  let mid = Math.floor(start + (end - start) / 2);

  if (arr[mid] === target) {
    return mid;
  } else if (arr[mid] > target) {
    return binarySearchRecursion(arr, 0, mid - 1, target);
  } else {
    return binarySearchRecursion(arr, mid + 1, end, target);
  }
}

let arr = [6, 8, 23, 24, 29, 39, 51, 90];

// let ans = binarySearch(arr, 51);

// console.log(ans);

let ans = binarySearchRecursion(arr, 0, arr.length - 1, 51);

console.log(ans);
