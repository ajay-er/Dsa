function merge(arr) {
  let totallength = arr.length;
  if (totallength <= 1) return arr;

  let mid = Math.floor(totallength / 2);

  let lArr = arr.slice(0, mid);
  let rArr = arr.slice(mid);

  return mergeSort(merge(lArr), merge(rArr));
}

function mergeSort(lArr, rArr) {
  let i = 0;
  let j = 0;
  let newArr = [];

  while (lArr.length > i && rArr.length > j) {
    if (lArr[i] > rArr[j]) {
      newArr.push(rArr[j]);
      j++;
    } else {
      newArr.push(lArr[i]);
      i++;
    }
  }

  while (lArr.length > i) {
    newArr.push(lArr[i]);
    i++;
  }

  while (rArr.length > j) {
    newArr.push(rArr[j]);
    j++;
  }
  return newArr;
}


let unsortedArray = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5];
let sortedArray = merge(unsortedArray);
console.log(sortedArray);
