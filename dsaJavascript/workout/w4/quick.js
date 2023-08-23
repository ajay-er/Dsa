function quick(arr, left, right) {
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

  quick(arr, s, right);
  quick(arr, left, e);
}



let arr = [29, 91, 23, 9, 1, 3, 74, 6];

quick(arr,0,arr.length-1);
console.log(arr);
