class Heap {
  constructor() {
    this.heap = [];
  }

  swap(index1, index2) {
    let temp = this.heap[index1];
    this.heap[index1] = this.heap[index2];
    this.heap[index2] = temp;
  }

  insert(value) {
    this.heap.push(value);
    this.bubbleUp(this.heap.length - 1);
  }

  bubbleUp(index) {
    const parentIndex = Math.floor((index - 1) / 2);
    if (index > 0 && this.heap[parentIndex] < this.heap[index]) {
      this.swap(parentIndex, index);
      this.bubbleUp(parentIndex);
    }
  }

  buildHeap(arr) {
    this.heap = arr;
    for (let i = Math.floor(this.heap.length / 2); i >= 0; i--) {
      this.heapify(i);
    }
  }

  heapify(index) {
    const leftIndex = 2 * index + 1;
    const rightIndex = 2 * index + 2;

    let largest = index;

    if (
      leftIndex < this.heap.length &&
      this.heap[largest] < this.heap[leftIndex]
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
      this.heapify(largest);
    }
  }
}


const maxHeap = new Heap();

// Test case 3: Building heap from an array
const arr = [8, 3, 10, 5, 15, 7];
maxHeap.buildHeap(arr);
console.log(maxHeap.heap); // Expected output: [15, 8, 10, 5, 3, 7]

// Test case 4: Insertion after building heap
maxHeap.insert(17);
console.log(maxHeap.heap); // Expected output: [17, 8, 15, 5, 3, 7, 10]

// Test case 5: Insertion of duplicate elements
maxHeap.insert(15);
console.log(maxHeap.heap); // Expected output: [17, 15, 15, 5, 8, 7, 10, 3]

// Test case 6: Insertion of negative numbers
maxHeap.insert(-5);
console.log(maxHeap.heap); // Expected output: [17, 15, 15, 5, 8, 7, 10, 3, -5]

// Test case 7: Building heap from an empty array
maxHeap.buildHeap([]);
console.log(maxHeap.heap); // Expected output: []

// Test case 8: Insertion into an empty heap after rebuilding
maxHeap.insert(25);
console.log(maxHeap.heap); // Expected output: [25]
