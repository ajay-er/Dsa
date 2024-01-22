const bracketMapping = {
  '(': ')',
  '{': '}',
  '[': ']',
};
function isValid(s) {
  const stack = [];

  for (let char of s) {
    if (bracketMapping[char]) {
      stack.push(char);
    } else {
      const lastOpenBracket = stack.pop();

      if (bracketMapping[lastOpenBracket] !== char) {
        return false;
      }
    }
  }

  return stack.length === 0;
}

// Test cases
console.log(isValid('()[]{}')); // true
console.log(isValid('([)]')); // false
