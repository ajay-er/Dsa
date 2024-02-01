class MinHeap {
  constructor() {
    this.heap = [];
  }

  insert(value) {
    this.heap.push(value);
    this.bubbleUp(this.heap.length - 1);
  }

  extractMin() {
    if (this.heap.length === 0) return null;
  
    if (this.heap.length === 1) return this.heap.pop();
  
    const minValue = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.bubbleDown(0);
  
    return minValue;
  }

  bubbleUp(index) {
    const parentIndex = Math.floor((index - 1) / 2);

    if (index > 0 && this.heap[index] < this.heap[parentIndex]) {
      [this.heap[index], this.heap[parentIndex]] = [
        this.heap[parentIndex],
        this.heap[index],
      ];
      this.bubbleUp(parentIndex);
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

  buildHeap(arr) {
    this.heap = [...arr];
    for (let i = Math.floor(this.heap.length / 2); i >= 0; i--) {
      this.bubbleDown(i);
    }
  }
}


const minHeap = new MinHeap();

minHeap.insert(4);
minHeap.insert(2);
minHeap.insert(8);
minHeap.insert(5);
minHeap.insert(1);

const arr = [10, 7, 3, 6, 2, 4];
minHeap.buildHeap(arr);

console.log(minHeap);