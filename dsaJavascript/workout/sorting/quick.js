function quickSort(arr, left, right) {
  if (left >= right) return;

  let s = left;
  let e = right;
  let pivot = arr[e];

  while (s <= e) {
    while (arr[s] < pivot) {
      s++;
    }

    while (arr[e] > pivot) {
      e--;
    }

    if (s <= e) {
      let temp = arr[e];
      arr[e] = arr[s];
      arr[s] = temp;
      e--;
      s++;
    }
  }

  quickSort(arr, left, e);
  quickSort(arr, s, right);
}

let arr = [9, 1, 3, 4, 84, 7];
quickSort(arr, 0, arr.length - 1);

console.log(arr);
