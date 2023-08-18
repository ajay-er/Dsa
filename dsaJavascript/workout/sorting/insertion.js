function insertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    for (let j = i; j > 0; j--) {
      if (arr[j] < arr[j - 1]) {
        swap(j, j - 1, arr);
      }else{
        break;
      }
    }
  }
}

function swap(i, j, arr) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

let arr = [95, 2, 8, 99, 23, 1];
insertionSort(arr);

console.log(arr);
