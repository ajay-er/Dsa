function quick(arr, low, high) {
  if (low < high) {
    let pivotIndex = partition(arr, low, high);
    quick(arr, low, pivotIndex - 1);
    quick(arr, pivotIndex + 1, high);
  }
}

function partition(arr, low, high) {
  let pivot = arr[high];
  let i = low - 1;

  for (let j = low; j < high; j++) {
    if (arr[j] <= pivot) {
      i++;
      swap(arr, i, j);
    }
  }
  swap(arr, i + 1, high);
  return i + 1;
}

function swap(arr, i, j) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

let arr = [2, 34, 5, 12, 3, -2, 1];
quick(arr, 0, arr.length - 1);
console.log(arr);
