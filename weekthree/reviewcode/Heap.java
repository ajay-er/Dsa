package reviewcode;

public class Heap {
    int size;
    int maxSize;
    int[] heap;

    Heap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize+1];
        heap[0] = Integer.MIN_VALUE;
    }

    int parent(int pos){
        return pos/2;
    }

    int leftChild(int pos){
        return pos * 2;
    }

    int rightChild(int pos){
        return pos * 2 + 1;
    }

    boolean isLeaf(int pos){
        return pos > size/2;
    }

    void swap(int indx1 , int indx2){
        int temp = heap[indx1];
        heap[indx1] = heap[indx2];
        heap[indx2] = temp;
    }

    void build(int[] arr){
        if(arr.length > maxSize){
            throw new IllegalArgumentException("array size exceeds heap");
        }
        int size = arr.length;
        System.arraycopy(arr, 0,heap, 1, size);
        for (int i = size/2; i >=1; i--) {
            heapify(i);
        }
    }

    private void heapify(int pos) {
        int left = leftChild(pos);
        int right = rightChild(pos);
        int smallest = pos;

        if(!isLeaf(pos)){

            if(heap[left] < heap[smallest]){
                smallest = left;
            }

            if(right<=size && heap[right] < heap[smallest]){
                smallest = right;
            }

            if(smallest!=pos){
                swap(pos, smallest);
                heapify(smallest);
            }
        }

    }

    void insert(int element){
        if(size >= maxSize){
            throw new IllegalArgumentException();
        }

        heap[++size] = element;
        int curr = size;
        while(heap[curr] < heap[parent(curr)]){
            swap(parent(curr), curr);
           curr = parent(curr);
        }
    }

    int remove(){
        if(size ==0){
            throw new IllegalArgumentException();
        }

        int v = heap[1];
        swap(1, size);
        size--;
        heapify(1);
        return v;
    }


    void heasSort(int[] arr){
        int n = arr.length;
        Heap hp = new Heap(n);

        hp.build(arr);

        for (int i = n-1; i>=0; i--) {
            arr[i] = hp.remove();
        }

        int lar = arr[0];
        int sec ;
        for (int i = 0; i < arr.length; i++) {
            // if()
        }
    }


    void print (){
        for (int i = 1; i <=size; i++) {
            
        }
    }

}
