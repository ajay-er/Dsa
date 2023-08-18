function mergeSort(arr) {
  if (arr.length < 2) return arr;
  let mid = Math.floor(arr.length / 2);
  let left = arr.slice(0, mid);
  let right = arr.slice(mid);

  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  let i = 0;
  let j = 0;
  let newArray = [];

  while (left.length > i && right.length > j) {
    if (left[i] > right[j]) {
      newArray.push(right[j]);
      j++;
    }else{
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

let arr = [9, 1, 3, 4, 84, 7, 13];

arr = mergeSort(arr);
console.log(arr);
