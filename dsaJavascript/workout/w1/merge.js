function merge(arr) {
  let length = arr.length;
  if (length <= 1) {
    return arr;
  }

  let mid = Math.floor(arr.length / 2);
  let left = arr.slice(0, mid);
  let right = arr.slice(mid);

  return mergeSort(merge(left), merge(right));
}

function mergeSort(left, right) {
  let i = 0;
  let j = 0;

  let newArray = [];

  while (left.length > i && right.length > j) {
    if (left[i] > right[j]) {
      newArray.push(right[j]);
      j++;
    } else {
      newArray.push(left[i]);
      i++;
    }
  }

  while (left.length > i) {
    newArray.push(left[i]);
    i++;
  }

  while (right.length > j) {
    newArray.push(right[j]);
    j++;
  }

  return newArray;
}

let arr = [3, 109, 2, 8899, 4, 61, 924, 5];

arr = merge(arr);

console.log(arr);
