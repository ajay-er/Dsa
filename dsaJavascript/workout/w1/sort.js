function swap(i, j, arr) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

function bubble(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        swap(j, j + 1, arr);
      }
    }
  }
}

function insertion(arr) {
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = i + 1; j > 0; j--) {
      if (arr[j] < arr[j - 1]) {
        swap(j - 1, j, arr);
      } else {
        break;
      }
    }
  }
}

function selection(arr) {
  for (let i = 0; i < arr.length ; i++) {
    let min = i;
    for (let j = i; j < arr.length; j++) {
      if (arr[j] < arr[min]) {
        min = j;
      }
    }
    if (min !== i) swap(min, i, arr);
  }
}

let arr = [3, 109, 2, 8899, 4, 61, 924, 5];

// bubble(arr);
// insertion(arr);
selection(arr);
console.log(arr);
