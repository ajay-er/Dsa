function factorial(n) {
  if (n === 1 || n === 0) {
    return 1;
  }
  return n * factorial(n - 1);
}

let num = factorial(5);
console.log(num);
