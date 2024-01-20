function merging(arr) {
  let totalLength = arr.length;

  if (totalLength <= 1) {
    return arr;
  }

  let mid = Math.floor(totalLength / 2);

  const leftArr = arr.slice(0, mid);
  const rightArr = arr.slice(mid);

  return mergeSort(merging(leftArr), merging(rightArr));
}

function mergeSort(leftArr, rightArr) {
  let i = 0;
  let j = 0;
  let newArr = [];

  while (leftArr.length > i && rightArr.length > j) {
    if (leftArr[i] > rightArr[j]) {
      newArr.push(rightArr[j]);
      j++;
    } else {
      newArr.push(leftArr[i]);
      i++;
    }
  }

  while (leftArr.length > i) {
    newArr.push(leftArr[i]);
    i++
  }
  while (rightArr.length > j) {
    newArr.push(rightArr[j]);
    j++
  }
  return newArr;
}


let arr = [2, 34, 5, 12, 3, -2, 1];
let ne = merging(arr);
console.log(ne);
