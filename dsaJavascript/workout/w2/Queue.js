class Queue {
  constructor() {
    this.items = [];
  }

  isEmpty() {
    return this.items.length === 0;
  }

  enqueue(data) {
    this.items.push(data);
  }

  dequeue() {
    if (this.isEmpty()) throw new Error('No values found');
    return this.items.shift();
  }

  peek() {
    if (this.isEmpty()) throw new Error('No values found');
    return this.items[0];
  }
}
