function swap(arr, i, j) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

function bubble(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        swap(arr, j, j + 1);
      }
    }
  }
}

function selection(arr) {
  for (let i = 0; i < arr.length - 1; i++) {
    let min = i;

    for (let j = i + 1; j < arr.length; j++) {
      if (arr[min] > arr[j]) {
        min = j;
      }
    }
    if (min !== i) {
      swap(arr, min, i);
    }
  }
}

function insertion(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j >= 0; j--) {
      if (arr[j] < arr[j - 1]) {
        swap(arr, j, j - 1);
      } else {
        break;
      }
    }
  }
}

let arr = [29, 91, 23, 9, 1, 3, 74, 6];

// bubble(arr);

// selection(arr);

insertion(arr);

console.log(arr);
