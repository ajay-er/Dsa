function merge(arr) {
  let totalLength = arr.length;

  if (totalLength <= 1) return arr;

  let mid = Math.floor(totalLength / 2);
  let leftArr = arr.slice(0, mid);
  let rightArr = arr.slice(mid);

  return mergeSort(merge(leftArr), merge(rightArr));
}

function mergeSort(leftArr, rightArr) {
  let newArr = [];
  let i = 0;
  let j = 0;

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
    i++;
  }
  while (rightArr.length > j) {
    newArr.push(rightArr[j]);
    j++;
  }

  return newArr;
}



let arr = [2, 34, 5, 12, 3, -2, 1];
let newar = merge(arr);
console.log(newar);
