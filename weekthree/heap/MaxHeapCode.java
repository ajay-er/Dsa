package heap;

public class MaxHeapCode {
    private int[] heap;
    private int maxSize;
    private int size;

    public MaxHeapCode(int maxSize) {
        this.maxSize = maxSize;
        heap = new int[maxSize + 1];
        size = 0;
        heap[0] = Integer.MAX_VALUE;
    }

    public void insert(int value) {
        if (size >= maxSize) {
            return;
        }
        size++;
        heap[size] = value;
        int currentIndex = size;
        while (heap[currentIndex] > heap[parent(currentIndex)]) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public int remove() {
        int max = heap[1];
        heap[1] = heap[size];
        size--;
        maxHeapify(1);
        return max;
    }

    private void maxHeapify(int index) {
        if (isLeaf(index)) {
            return;
        }
        if (heap[index] < heap[leftChild(index)] || heap[index] < heap[rightChild(index)]) {
            if (heap[leftChild(index)] > heap[rightChild(index)]) {
                swap(index, leftChild(index));
                maxHeapify(leftChild(index));
            } else {
                swap(index, rightChild(index));
                maxHeapify(rightChild(index));
            }
        }
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    private boolean isLeaf(int index) {
        return index > size / 2 && index <= size;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void buildHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        MaxHeapCode maxHeap = new MaxHeapCode(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(40);
        System.out.println("Max heap size: " + maxHeap.getSize());
        System.out.println("Max element: " + maxHeap.remove());
        System.out.println("Max heap size: " + maxHeap.getSize());
        int[] array = {5, 2, 7, 8, 3};
        MaxHeapCode maxHeapFromArray = new MaxHeapCode(10);
        maxHeapFromArray.buildHeap(array);
        System.out.println("Max heap size: " + maxHeapFromArray.getSize());
        System.out.println("Max element: " + maxHeapFromArray.remove());
        System.out.println("Max heap size: " + maxHeapFromArray.getSize());
    }
}
