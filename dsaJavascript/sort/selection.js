function selectionSort(arr) {
  for (let i = 0; i < arr.length; i++) {
    let min = i;
    for (let j = i; j < arr.length; j++) {
      if (arr[min] > arr[j]) {
        min = j;
      }
    }
    swap(min, i, arr);
  }
}

function swap(j, i, arr) {
  let temp = arr[j];
  arr[j] = arr[i];
  arr[i] = temp;
}

let arr = [291, 21, 1, 29, 3, -2];

selectionSort(arr);
console.log(arr);
