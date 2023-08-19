function insertion2(arr) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = i; j > 0; j--) {
      if (arr[j] < arr[j - 1]) {
        swap(arr, j, j - 1);
      } else {
        break;
      }
    }
  }
}
function swap(arr, j, i) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}


let arr = [2, 35, 9, 1, 23,29,12,11,999];

insertion2(arr);

console.log(arr);