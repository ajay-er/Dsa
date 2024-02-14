function quicksort(arr) {
  quicksortHelper(arr, 0, arr.length - 1);
}

function quicksortHelper(arr, lowIndex, highIndex) {
  if (lowIndex < highIndex) {
    let pivotIndex = partition(arr, lowIndex, highIndex);
    quicksortHelper(arr, lowIndex, pivotIndex - 1);
    quicksortHelper(arr, pivotIndex + 1, highIndex);
  }
}

function partition(arr, lowIndex, highIndex) {
  let pivotIndex = highIndex;
  let pivot = arr[pivotIndex];

  swap(arr, pivotIndex, highIndex);

  let leftPointer = lowIndex;
  let rightPointer = highIndex - 1;

  while (leftPointer <= rightPointer) {
    while (arr[leftPointer] <= pivot && leftPointer <= rightPointer) {
      leftPointer++;
    }

    while (arr[rightPointer] >= pivot && leftPointer <= rightPointer) {
      rightPointer--;
    }

    if (leftPointer < rightPointer) {
      swap(arr, leftPointer, rightPointer);
    }
  }

  swap(arr, leftPointer, highIndex);
  return leftPointer;
}

function swap(array, index1, index2) {
  let temp = array[index1];
  array[index1] = array[index2];
  array[index2] = temp;
}

let numbers = [];
for (let i = 0; i < 10; i++) {
  numbers.push(Math.floor(Math.random() * 100));
}

console.log('Before:', numbers);
quicksort(numbers);
console.log('After:', numbers);
