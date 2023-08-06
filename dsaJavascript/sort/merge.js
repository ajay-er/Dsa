function mergeSort(arr) {
  let totalLength = arr.length;

  if (totalLength <= 1) {
    return arr;
  }

  let mid = Math.floor(totalLength / 2);
  let leftArr = arr.slice(0, mid);
  let rightArr = arr.slice(mid);

  return merge(mergeSort(leftArr), mergeSort(rightArr));
}

function merge(left, right) {
  const mergedArray = [];
  let i = 0;
  let j = 0;

  while (i < left.length && j < right.length) {
    if (left[i] <= right[j]) {
      mergedArray.push(left[i]);
      i++;
    } else {
      mergedArray.push(right[j]);
      j++;
    }
  }

  while (i < left.length) {
    mergedArray.push(left[i]);
    i++;
  }

  while (j < right.length) {
    mergedArray.push(right[j]);
    j++;
  }

  return mergedArray;
}

let arr = [291, 21, 1, 29, 3, -2];

let sort = mergeSort(arr);
console.log(sort);
