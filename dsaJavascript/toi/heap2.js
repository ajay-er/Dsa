class Heap {
  constructor() {
    this.heap = [];
  }

  swap(i, j) {
    let temp = this.heap[i];
    this.heap[i] = this.heap[j];
    this.heap[j] = temp;
  }

  buildHeap(arr) {
    this.heap = arr;
    for (let i = Math.floor(this.heap.length / 2); i >= 0; i--) {
      this.#heapify(i);
    }
  }

  #heapify(index) {
    let leftIndex = 2 * index + 1;
    let rightIndex = 2 * index + 2;

    let largest = index;

    if (
      leftIndex < this.heap.length &&
      this.heap[leftIndex] > this.heap[largest]
    ) {
      largest = leftIndex;
    }

    if (
      rightIndex < this.heap.length &&
      this.heap[rightIndex] > this.heap[largest]
    ) {
      largest = rightIndex;
    }

    if (largest !== index) {
      this.swap(largest, index);
      this.#heapify(largest);
    }
  }
}
