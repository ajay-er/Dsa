package heap.heapsortworkout;

import java.util.Arrays;

public class MinHeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build min heap
        for (int i = n / 2 - 1; i >= 0; i--)
            minHeapify(arr, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Min heapify the reduced heap
            minHeapify(arr, i, 0);
        }
    }

    private static void minHeapify(int[] arr, int n, int i) {
        int smallest = i; // Initialize smallest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is smaller than root
        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        // If right child is smaller than smallest so far
        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        // If smallest is not root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursively heapify the affected sub-tree
            minHeapify(arr, n, smallest);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        System.out.println("Original array: " + Arrays.toString(arr));
    
        MinHeapSort.heapSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
}
