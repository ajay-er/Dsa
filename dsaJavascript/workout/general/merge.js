function merge(arr) {
  let length = arr.length;

  if (length < 2) {
    return arr;
  }

  let mid = Math.floor(length / 2);
  let left = arr.slice(0, mid);
  let right = arr.slice(mid);

  return sort(merge(left), merge(right));
}

function sort(left, right) {
  let newArray = [];
  let i = 0;
  let j = 0;

  while (left.length > i && right.length > j) {
    if (left[i] > right[j]) {
      newArray.push(right[j]);
      j++;
    } else {
      newArray.push(left[i]);
      i++;
    }
  }

  while(left.length > i){
    newArray.push(left[i]);
    i++
  }

  while(right.length > j){
    newArray.push(right[j]);
    j++
  }

  return newArray
}

let arr = [12, 3, 1, 923, 2];
arr=merge(arr);
console.log(arr);
