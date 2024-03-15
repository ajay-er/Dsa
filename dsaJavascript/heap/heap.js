class Heap {
  constructor() {
    this.heap = [];
  }

  heapify(arr) {
    this.heap = arr;
    for (let i = Math.floor(this.heap.length / 2); i >= 0; i--) {
      this.make(i);
    }
  }

  make(index) {
    let leftIndex = 2 * index + 1;
    let rightIndex = 2 * index + 2;

    let smallest = index;

    if (
      leftIndex < this.heap.length &&
      this.heap[leftIndex] < this.heap[smallest]
    ) {
      smallest = leftIndex;
    }
    if (
      rightIndex < this.heap.length &&
      this.heap[rightIndex] < this.heap[smallest]
    ) {
      smallest = rightIndex;
    }

    if (smallest !== index) {
      [this.heap[index], this.heap[smallest]] = [
        this.heap[smallest],
        this.heap[index],
      ];
      this.make(smallest);
    }
  }
}

const heap = new Heap();
heap.heapify([4, 10, 3, 5, 1]);
console.log(heap.heap); // Output: [1, 4, 3, 5, 10] - represents a min-heap
