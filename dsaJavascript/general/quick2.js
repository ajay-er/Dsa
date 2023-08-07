function quick(arr, left, right) {
  if (left >= right) return;

  let s = left;
  let e = right;
  let pivot = arr[Math.floor((left + right) / 2)];

  while (s <= e) {
    while (arr[s] < pivot) {
      s++;
    }

    while (arr[e] > pivot) {
      e--;
    }

    if (s <= e) {
      let temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
      s++;
      e--;
    }
  }

  quick(arr, left, e);
  quick(arr, s, right);
}

let arr = [9, 1, 3, 4, 84, 7];
quick(arr, 0, arr.length - 1);
console.log(arr);
