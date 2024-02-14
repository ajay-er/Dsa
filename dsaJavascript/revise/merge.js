function mergeSort(arr) {
  if (arr.length <= 1) {
    return arr;
  }

  let mid = Math.floor(arr.length - 1 / 2);

  let leftArr = arr.slice(0, mid);
  let rightArr = arr.slice(mid);

  return merge(mergeSort(leftArr), mergeSort(rightArr));
}

function merge(leftArr, rightArr) {
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
    i++;
  }

  while (rightArr.length > j) {
    newArr.push(rightArr[j]);
    j++;
  }

  return newArr;
}



let arr = [291, 21, 1, 29, 3, 235, -2];

let sort = mergeSort(arr);
console.log(sort);