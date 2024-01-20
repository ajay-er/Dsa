class Queue {
  constructor() {
    this.itmes = [];
  }

  enqueue(item) {
    this.itmes.push(item);
  }

  dequeue() {
    this.itmes.shift();
  }

  peek() {
    return this.itmes[0];
  }
}
