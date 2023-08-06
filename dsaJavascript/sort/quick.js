/* 
 function quickSort(arr) {
  if (arr.length < 2) {
    return arr;
  }

  let pivot = arr[arr.length - 1];
  let left = [];
  let right = [];

  for (let i = 0;i < arr.length - 1;i++) {
    if (arr[i] < pivot) {
      left.push(arr[i]);
    } else {
      right.push(arr[i]);
    }
  }

  return [...quickSort(left), pivot, ...quickSort(right)];
}

let arr = [291, 21, 1, 29, 3, -2];

let sort = quickSort(arr);
console.log(sort);
 */

function quickSort(arr, start = 0, end = arr.length - 1) {
  if (start <= end) {
    let pivotIndex = partition(arr, start, end);
    quickSort(arr, start, pivotIndex - 1);
    quickSort(arr, pivotIndex + 1, end);
}
return arr;
}

function partition(arr, start, end) {
  const pivotValue = arr[start];
  let swapIndex = start;
  for (let i = start + 1; i <= end; i++) {
    if (pivotValue > arr[i]) {
      swapIndex++;
      if (i !== swapIndex) {
        [arr[i], arr[swapIndex]] = [arr[swapIndex], arr[i]];
      }
    }
  }

  if (swapIndex !== start) {
    [arr[swapIndex], arr[start]] = [arr[start], arr[swapIndex]];
  }
  return swapIndex;
}

let arr = [64, 34, 25, 12, 22, 11, 90];
quickSort(arr);
console.log(arr);
