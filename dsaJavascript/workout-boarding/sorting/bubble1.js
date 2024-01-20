function bubble(arr) {
  let swapped = false;
  for (let i = 0; i < arr.length; i++) {
    swapped = false;
    for (let j = 0; j < arr.length - i -1; j++) {
      if (arr[j] > arr[j + 1]) {
        swap(arr, j, j + 1);
        swapped = true;
      }
    }
    if (!swapped) {
      break;
    }
  }
}

function swap(arr, i, j) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

let arr = [2, 34, 5, 12, 3, -2, 1];
bubble(arr);
console.log(arr);
