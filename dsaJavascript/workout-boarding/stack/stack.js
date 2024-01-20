class Stack {
    constructor() {
      this.items = [];
    }
  
    push(item) {
      this.items.push(item);
    }
  
    pop() {
      if (!this.isEmpty()) {
        return this.items.pop();
      }
  
      return null;
    }
  
    isEmpty() {
      return this.items.length === 0;
    }
  
    peek() {
      if (!this.isEmpty()) {
        return this.items[this.items.length - 1];
      }
  
      return null;
    }
  
    clear() {
      this.items = [];
    }
  
    size() {
      return this.items.length;
    }
  }
  
  const stack = new Stack();
  
  stack.push(23);
  stack.push(2);
  stack.push(3);
  stack.push(5);
  
  console.log(stack.peek());
  console.log(stack.pop());
  
  console.log(stack.size());
  