function mergeSortWaala(arr) {
  if (arr.length <= 1) {
    return arr;
  }

  let mid = Math.floor(arr.length / 2);
  let left = arr.slice(0, mid);
  let right = arr.slice(mid);

  return merge(mergeSortWaala(left), mergeSortWaala(right));
}

function merge(left, right) {
  let leftLength = left.length;
  let rightLength = right.length;
  let i = 0;
  let j = 0;

  let newArray = [];

  while (i < leftLength && j < rightLength) {
    if (left[i] < right[j]) {
      newArray.push(left[i]);
      i++;
    }

    if (left[i] > right[j]) {
      newArray.push(right[j]);
      j++;
    }
  }

  while (i < leftLength) {
    newArray.push(left[i]);
    i++;
  }

  while (j < rightLength) {
    newArray.push(right[j]);
    j++;
  }

  return newArray;
}

let arr = [29, 19, 3, 2, 1, 5];

console.log(mergeSortWaala(arr));
