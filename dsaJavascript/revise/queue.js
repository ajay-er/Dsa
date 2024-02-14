class Queue {
  constructor() {
    this.queue = [];
  }

  isEmpty() {
    return this.queue.length === 0;
  }

  enqueue(value) {
    this.queue.push(value);
  }

  dequeue() {
    if (this.isEmpty()) return 'Queue is empty';
    return this.queue.shift();
  }
}
