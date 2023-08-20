class Stack {
  constructor() {
    this.items = [];
  }

  push(value) {
    this.items.push(value);
  }

  pop() {
    if (!this.isEmpty()) {
      return this.items.pop();
    }
    console.log('Stack is empty');
  }

  isEmpty() {
    return this.items.length === 0;
  }


  peek(){
    return !this.isEmpty()? this.items[this.items.length - 1]:  new Error('No value in the stack')
  }

}
