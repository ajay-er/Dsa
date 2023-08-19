function mergeSort(arr) {
  if (arr.length <= 1) {
    return arr;
  } else {
    let mid = arr.length / 2;

    let left = arr.slice(0, mid);

    let right = arr.slice(mid);

    return merge(mergeSort(left), mergeSort(right));
  }
}

function merge(left, right) {
  let i = 0;
  let j = 0;

  let newArray = [];
  while (left.length > i && right.length > j) {
    if (left[i] < right[j]) {
      newArray.push(left[i]);
      i++;
    } else {
      newArray.push(right[j]);
      j++;
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

let arr = [2, 35, 9, 1, 23, 29, 12, 11, 999, 91];

arr = mergeSort(arr);

console.log(arr);
