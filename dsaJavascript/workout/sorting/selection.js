function swap(i, j, arr) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

function selectionSort(arr) {
  for (let i = 0; i < arr.length; i++) {
    let min = arr[i];
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < min) {
        swap(j, i, arr);
      }
    }
  }
}

let arr = [2, 5, 8, 99, 23];
selectionSort(arr);

console.log(arr);
