class Stack {
  #items;
  constructor() {
    this.#items = [];
  }

  getStack() {
    return this.#items;
  }

  push(value) {
    this.#items.push(value);
  }

  pop() {
    if (!this.isEmpty()) {
      return this.#items.pop();
    }
    return null;
  }

  peek() {
    if (!this.isEmpty()) {
      return this.#items[this.#items.length - 1];
    }
    return null;
  }

  isEmpty() {
    return this.#items.length === 0;
  }
}

let stack = new Stack();

stack.push(23);
stack.push(1);
stack.push(8);
stack.push(3);
stack.push(7);

console.log(stack.peek());

console.log(stack.getStack());
