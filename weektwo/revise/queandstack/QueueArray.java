package revise.queandstack;

public class QueueArray {
    int arr[];
    int front;
    int rear;
    int capacity;

    QueueArray() {
        this.capacity = 10;
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return front == 0 && rear == capacity - 1;
    }

    void enQ(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if(front == -1){
            front = 0;
        }
        arr[++rear] = x;
    }

    int deQ(){
        if(isEmpty()){
            System.out.println("Q is empty");
            return -1;
        }
        int val = arr[front];
        if(front == rear ){
            front = -1;
            rear = -1;
        }else{
            front++;
        }
        return val;
    }

    void display(){
        if(isEmpty()){
            System.out.println("Q is Empty");
            return;
        }
        for (int i = front; i <=rear; i++) {
            System.out.print(arr[i]+" --> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray();
        q.deQ();
        q.enQ(2);
        q.enQ(1);
        q.enQ(4);
        q.enQ(3);
        q.display();
        q.deQ();
        q.deQ();
        q.deQ();
        q.display();
        q.enQ(9);
        q.display();


    }
}
