package heap;

import java.util.*;

public class MinHeapCode {
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeapCode(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize + 1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        size++;
        heap[size] = element;
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int remove() {
        int popped = heap[1];
        heap[1] = heap[size];
        size--;
        minHeapify(1);
        return popped;
    }

    private void minHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        int left = leftChild(pos);
        int right = rightChild(pos);
        if (right > size) {
            return;
        }
        if (right == size) {
            if (heap[pos] > heap[left]) {
                swap(pos, left);
            }
            return;
        }
        if (heap[pos] > heap[left] || heap[pos] > heap[right]) {
            if (heap[left] < heap[right]) {
                swap(pos, left);
                minHeapify(left);
            } else {
                swap(pos, right);
                minHeapify(right);
            }
        }
    }
    

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos > (size / 2) && pos <= size;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    public void buildHeap(int[] array) {
        heap = new int[array.length + 1];
        maxSize = array.length;
        size = array.length;
        System.arraycopy(array, 0, heap, 1, array.length);
        for (int pos = size / 2; pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int balance() {
        if (size < 2) {
            return 0;
        }
        int left = leftChild(1);
        int right = rightChild(1);
        if (right > size) {
            return -heap[left];
        }
        return heap[right] - heap[left];
    }

    public static void main(String[] args) {
        MinHeapCode minHeap = new MinHeapCode(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(6);
        minHeap.insert(2);
        minHeap.insert(7);

        System.out.println("The minimum value in the heap is: " + minHeap.remove());
        System.out.println("The current balance of the heap is: " + minHeap.balance());

        int[] array = {10, 4, 8, 6, 12, 15};
        MinHeapCode minHeap2 = new MinHeapCode(array.length);
        minHeap2.buildHeap(array);

        System.out.println("The minimum value in the heap is: " + minHeap2.remove());
        System.out.println("The current balance of the heap is: " + minHeap2.balance());
        minHeap2.insert(3);
        minHeap2.insert(1);
        minHeap2.insert(9);

        System.out.println("The minimum value in the heap is: " + minHeap2.remove());
        System.out.println("The current balance of the heap is: " + minHeap2.balance());
    }
}

