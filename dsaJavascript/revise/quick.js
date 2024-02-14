function quicksort(array) {
  quicksortHelper(array, 0, array.length - 1);
}

function quicksortHelper(array, lowIndex, highIndex) {
  if (lowIndex < highIndex) {
    let pivotIndex = partition(array, lowIndex, highIndex);
    quicksortHelper(array, lowIndex, pivotIndex - 1);
    quicksortHelper(array, pivotIndex + 1, highIndex);
  }
}

function partition(array, lowIndex, highIndex) {
  let pivotIndex = Math.floor(Math.random() * (highIndex - lowIndex + 1)) + lowIndex;
  let pivot = array[pivotIndex];
  swap(array, pivotIndex, highIndex);

  let leftPointer = lowIndex;
  let rightPointer = highIndex - 1;

  while (leftPointer <= rightPointer) {
    while (array[leftPointer] <= pivot && leftPointer <= rightPointer) {
      leftPointer++;
    }

    while (array[rightPointer] >= pivot && leftPointer <= rightPointer) {
      rightPointer--;
    }

    if (leftPointer < rightPointer) {
      swap(array, leftPointer, rightPointer);
    }
  }

  swap(array, leftPointer, highIndex);

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

console.log("Before:", numbers);
quicksort(numbers);
console.log("After:", numbers);
