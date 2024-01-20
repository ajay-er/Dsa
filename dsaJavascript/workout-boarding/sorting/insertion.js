function insertion(arr) {
  for (let i = 1; i < arr.length; i++) {
    for (let j = i; j >= 1; j--) {
      if (arr[j] < arr[j - 1]) {
        swap(arr, j, j - 1);
      } else {
        break;
      }
    }
  }
}

function swap(arr, i, j) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

let arr = [2, 34, 5, 12, 3, -2, 1];
insertion(arr);
console.log(arr);
