package revise;

public class Heap {
    private int[] heap;
    private int size;
    private int maxSize;

    public Heap(int maxSize) {
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
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    public void build(int[] arr) {
        if (arr.length > maxSize) {
            throw new IllegalArgumentException("array size exceds heap");
        }
        size = arr.length;
        System.arraycopy(arr, 0, heap, 1, size);
        for (int i = size / 2; i >= 1; i--) {
            minHeapify(i);
        }
    }

    private void minHeapify(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int smallest = pos;

        if (!isLeaf(pos)) {

            if (heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right <= size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != pos) {
                swap(smallest, pos);
                minHeapify(smallest);
            }

        }
    }

    void insert(int element) {
        if (size >= maxSize) {
            throw new IllegalArgumentException("Heap is full");
        }

        heap[++size] = element;
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(heap[current], heap[parent(current)]);
            swap(current, parent(current));
            current = parent(current);
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

    boolean isEmpty() {
        return size == 0;
    }

    int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[1];
    }

    void print() {
        System.out.print("Heap : ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap mHeap = new Heap(10);
        int arr[] = { 22, 5, 19, 2, 35, 91, 28 };
        mHeap.build(arr);
        mHeap.print();
    }
}
