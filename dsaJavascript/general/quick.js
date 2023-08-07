function quick(arr, low = 0, high = arr.length - 1) {
  if (low < high) {
    let pivotIndex = partition(arr, low, high);
    quick(arr, low, pivotIndex - 1);
    quick(arr, pivotIndex + 1, high);
  }
  return arr;
}

function partition(arr, low, high) {
  let pivotValue = arr[low];
  let index = low;

  for (let i = low; i <= high; i++) {
    if (pivotValue > arr[i]) {
      index++;

      if (i !== index) [arr[i], arr[index]] = [arr[index], arr[i]];
    }
  }

  if (low !== index) [arr[low], arr[index]] = [arr[index], arr[low]];

  return index;
}

let arr = [2, 31, 239, 1, 39];
quick(arr);
console.log(arr);
