package implementation;

public class Heap {
    private int[] heap;
    private int size;
    private int maxSize;

    Heap(int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        heap = new int[maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return pos * 2 + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > size / 2;
    }

    private void swap(int num1, int num2) {
        int tem = heap[num1];
        heap[num1] = heap[num2];
        heap[num2] = tem;
    }

    void build(int[] arr) {
        if (arr.length > maxSize) {
            throw new IllegalArgumentException("array size is exceeds heap");
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
                swap(pos, smallest);
                minHeapify(smallest);
            }
        }

    }

    private void insert(int element) {
        if (size >= maxSize) {
            throw new IllegalArgumentException("heap is full");
        }

        heap[++size] = element;
        int curr = size;
        while (heap[curr] < heap[parent(curr)]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    private int remove() {
        if (size < 1) {
            throw new IllegalStateException("heap is empty can't delete");
        }

        int remove = heap[1];
        swap(1, size);
        size--;
        minHeapify(1);
        return remove;
    }

    void print() {
        System.out.print("heap : ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // public static void main(String[] args) {
    //     int arr[] = { 7, 1, 28, 23, 2, 9 };
    //     Heap hp = new Heap(8);
    //     hp.build(arr);
    //     hp.print();

    //     hp.remove();
    //     hp.print();

    //     hp.insert(8);
    //     hp.print();

    //     hp.insert(0);
    //     hp.print();
    // }

    void heapSort(int[] arr){
        Heap h = new Heap(arr.length);
        h.build(arr);
        // h.print();
        int n = arr.length;
        for (int i = n-1; i >=0; i--) {
            arr[i] = h.remove();
        }

        System.out.println("Heap sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2,5,4,1,3};
        Heap hp = new Heap(5);
        hp.heapSort(arr);
    }

}


