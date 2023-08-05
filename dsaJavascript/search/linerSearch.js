function linearSearch(arr, target) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) return i;
  }

  return -1;
}

let arr = [1, 51, 2, 93, 61, 39];
let linear = linearSearch(arr, 39);

console.log('Given target Index is', linear);
