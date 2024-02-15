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
    this.#bubbleup(this.heap.length - 1);
  }

  #bubbleup(index) {
    const parentIndex = Math.floor((index - 1) / 2);
    if (index > 0 && this.heap[index] < this.heap[parentIndex]) {
      this.swap(parentIndex, index);
      this.#bubbleup(parentIndex);
    }
  }

  buildHeap(arr) {
    this.heap = arr;
    for (let i = Math.floor(this.heap.length / 2); i >= 0; i--) {
      this.#heapify(i);
    }
  }

  #heapify(index) {
    const leftIndex = 2 * index + 1;
    const rightIndex = 2 * index + 2;

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

    if (smallest != index) {
      this.swap(index, smallest);
      this.#heapify(smallest);
    }
  }

  extractMin() {
    if (this.heap.length === 0) {
      return undefined;
    }

    if (this.heap.length === 1) {
      return this.heap.pop();
    }
    const min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.#heapify(0);
    return min;
  }
}

function heapSort(arr) {
  const heap = new Heap();
  heap.buildHeap(arr);

  const sortedArray = [];
  while (heap.heap.length > 0) {
    sortedArray.push(heap.extractMin());
  }

  return sortedArray;
}

const unsortedArray = [4, 10, 3, 5, 1];
console.log('Unsorted Array:', unsortedArray);

const sortedArray = heapSort(unsortedArray);

console.log('Sorted Array:', sortedArray);
