const brackets = {
  '{': '}',
  '(': ')',
  '[': ']',
};

function isValid(str) {
  const stack = [];

  for (const char of str) {
    if (brackets[char]) {
      stack.push(char);
    } else {
      let lastOpeningBracket = stack.pop();
      if (brackets[lastOpeningBracket] !== char) {
        return false;
      }
    }
  }

  return stack.length === 0;
}

console.log(isValid('()['));
