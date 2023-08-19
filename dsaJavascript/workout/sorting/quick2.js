function quick2(arr, left, right) {
  if (left >= right) return;

  let s = left;
  let e = right;
  let pivot = arr[e];

  while (s <= e) {
    while (pivot > arr[s]) {
      s++;
    }

    while (pivot < arr[e]) {
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

  quick2(arr, left, e);
  quick2(arr, s, right);
}

let arr = [9, 1, 3, 4, 84, 7];
quick2(arr, 0, arr.length - 1);

console.log(arr);
