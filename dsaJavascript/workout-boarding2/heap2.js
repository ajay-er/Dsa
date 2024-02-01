class MinHeap {
  constructor() {
    this.heap = [];
  }

  insert(value) {
    this.heap.push(value);
    this.#bubbleUp(this.heap.length - 1);
  }

  #bubbleUp(index) {
    const parent = Math.floor((index - 1) / 2);

    if (index > 0 && this.heap[index] < this.heap[parent]) {
      [this.heap[index], this.heap[parent]] = [
        this.heap[parent],
        this.heap[index],
      ];
      this.#bubbleUp(parent);
    }
  }

  buildHeap(arr) {
    this.heap = [...arr];
    for (let i = Math.floor(this.heap.length / 2); i >= 0; i--) {
      this.#bubbleDown(i);
    }
  }

  #bubbleDown(index) {
    const leftInx = 2 * index + 1;
    const rightInx = 2 * index + 2;

    let smallest = index;

    if (
      leftInx < this.heap.length &&
      this.heap[leftInx] < this.heap[smallest]
    ) {
      smallest = leftInx;
    }
    if (
      rightInx < this.heap.length &&
      this.heap[rightInx] < this.heap[smallest]
    ) {
      smallest = rightInx;
    }

    if (smallest !== index) {
      [this.heap[index], this.heap[smallest]] = [
        this.heap[smallest],
        this.heap[index],
      ];
      this.#bubbleDown(smallest);
    }
  }
}
