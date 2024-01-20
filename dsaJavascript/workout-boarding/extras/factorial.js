function factorial(n) {
  if (n <= 1) return n;

  return n * factorial(n - 1);
}

// 1 * 2 * 3 * 4
let result = factorial(4);
console.log(result);
