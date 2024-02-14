function insertionSort(arr) {
  for (let i = 1; i < arr.length; i++) {
    for (let j = i; j >= 1; j--) {
      if (arr[j] < arr[j - 1]) {
        swap(j, j - 1, arr);
      } else {
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

let arr = [91, 219, 1, 29, 3, -2];

insertionSort(arr);
console.log(arr);
