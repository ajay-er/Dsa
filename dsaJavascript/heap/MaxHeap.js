class MinHeap {
  constructor() {
    this.heap = [];
  }

  insert(value) {
    this.heap.push(value);
    this.bubbleup(this.heap.length - 1);
  }

  remove() {
    if (this.heap.length === 0) return null;

    if (this.heap.length === 1) return this.heap.pop();

    const minValue = this.heap[0];

    this.heap[0] = this.heap.pop();

    this.bubbleDown(0);

    return minValue;
  }

  bubbleup(index) {
    const parentIndex = Math.floor((index - 1) / 2);

    if (index > 0 && this.heap[index] < this.heap[parentIndex]) {
      [this.heap[index], this.heap[parentIndex]] = [
        this.heap[parentIndex],
        this.heap[index],
      ];
      this.bubbleup(parentIndex);
    }
  }

  bubbleDown(index) {
    const leftIdx = 2 * index + 1;
    const rightIdx = 2 * index + 2;

    let smallest = index;

    if (
      leftIdx < this.heap.length &&
      this.heap[leftIdx] < this.heap[smallest]
    ) {
      smallest = leftIdx;
    }

    if (
      rightIdx < this.heap.length &&
      this.heap[rightIdx] < this.heap[smallest]
    ) {
      smallest = rightIdx;
    }

    if (smallest !== index) {
      [this.heap[smallest], this.heap[index]] = [
        this.heap[index],
        this.heap[smallest],
      ];
      this.bubbleDown(smallest);
    }
  }

  build(arr) {
    this.heap = [...arr];
    for (let i = Math.floor(this.heap.length / 2); i >= 0; i--) {
      this.bubbleDown(i);
    }
  }
}
