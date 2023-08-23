function mergeSort(arr) {
  if (arr.length <= 1) {
    return arr;
  }

  let mid = Math.floor(arr.length / 2);

  let left = arr.slice(0, mid);
  let right = arr.slice(mid);

  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  let i = 0;
  let j = 0;
  let newArray = [];

  while (i < left.length && j < right.length) {
    if (left[i] > right[j]) {
      newArray.push(right[j]);
      j++;
    } else {
      newArray.push(left[i]);
      i++;
    }
  }

  while (i < left.length) {
    newArray.push(left[i]);
    i++;
  }
  while (j < right.length) {
    newArray.push(right[j]);
    j++;
  }
  return newArray;
}

let arr = [29, 91, 23, 9, 1, 3, 74, 6];

console.log(mergeSort(arr));
