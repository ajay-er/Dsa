class Queue {
  #items;
  constructor() {
    this.#items = [];
  }

  print() {
    return this.#items;
  }

  enQueue(value) {
    this.#items.push(value);
  }

  deQueue() {
    if (!this.isEmpty()) {
      return this.#items.shift();
    }
    return null;
  }

  peek() {
    if (!this.isEmpty()) {
      return this.#items[this.#items.length - 1];
    }
  }

  isEmpty() {
    return this.#items.length === 0;
  }
}

let q = new Queue();

q.enQueue(3);
q.enQueue(13);
q.enQueue(9);
q.enQueue(1);

console.log(q.print());
q.deQueue();
console.log(q.print());
