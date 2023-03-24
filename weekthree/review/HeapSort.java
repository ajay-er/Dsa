

import java.util.Arrays;

import revise.Heap;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a heap from the input array
        Heap heap = new Heap(n);
        heap.build(arr);

        // Sort the array using the heap
        for (int i = n - 1; i >= 0; i--) {
            // Remove the root and place it at the end of the array
            int temp = heap.remove();
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {22, 5, 19, 2, 35, 91, 28};

        System.out.println("Input array:");
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
