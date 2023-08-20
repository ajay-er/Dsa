function quick(arr, left, right) {
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
      let temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
      e--;
      s++;
    }
  }

  quick(arr, left, e);
  quick(arr, s, right);
}

let arr = [3, 109, 2, 8899, 4, 61, 924, 5];

quick(arr, 0, arr.length - 1);

console.log(arr);
