class Stack {
  constructor() {
    this.stack = [];
  }

  isEmpty() {
    return this.stack.length === 0;
  }

  push(value) {
    this.stack.push(value);
  }

  pop() {
    if (this.isEmpty) return 'UNDERFLOW';
    return this.stack.pop();
  }

  print() {
    console.log(this.stack.join(' '));
  }
}
const myStack = new Stack();

myStack.push(10);
myStack.push(20);
myStack.push(30);

console.log('Stack elements:');
myStack.print();
