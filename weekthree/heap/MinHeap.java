package heap;

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > size / 2;
    }

    private void swap(int pos1, int pos2) {
        int tmp;
        tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int smallest = pos;
            if (heap[left] < heap[smallest]) {
                smallest = left;
            }
            if (right <= size && heap[right] < heap[smallest]) {
                smallest = right;
            }
            if (smallest != pos) {
                swap(pos, smallest);
                minHeapify(smallest);
            }
        }
    }

    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int removed = heap[1];
        heap[1] = heap[size];
        size--;
        minHeapify(1);
        return removed;
    }

    public void insert(int element) {
        if (size >= maxSize) {
            throw new IllegalArgumentException("Heap is full");
        }
        size++;
        heap[size] = element;
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void build(int[] arr) {
        if (arr.length > maxSize) {
            throw new IllegalArgumentException("Array size exceeds heap size");
        }
        size = arr.length;
        System.arraycopy(arr, 0, heap, 1, size);
        for (int i = size / 2; i >= 1; i--) {
            minHeapify(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        System.out.print("Heap: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);
        int[] arr = { 6, 2, 7, 3, 8, 1, 9, 4, 5 };
        minHeap.build(arr);
        minHeap.print(); // prints the heap in tree format
        minHeap.insert(0);
        minHeap.print();
        minHeap.remove();
        minHeap.print();
        
    }
}
