package repeat;

public class Queue {
    private int[] data;
    private int front;
    private int rear;
    private int capacity;
    private final static int DEFAULT_SIZE = 10;

    Queue() {
        this(DEFAULT_SIZE);
    }

    Queue(int size) {
        data = new int[size];
        front = -1;
        rear = -1;
        capacity = size;
    }

    boolean isFull() {
        return front == 0 && rear == capacity - 1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enQueue(int value) throws StackExceptions {

        if (isFull()) {
            throw new StackExceptions("Stack is full");
        }

        if (front == -1) {
            front = 0;
        }
        data[++rear] = value;
    }

    int deQueue() throws StackExceptions {
        if(isEmpty()){
            throw new StackExceptions("Stack is Empty");
        }
        int val = data[front];
        if(rear==front){
            front = -1;
            rear = -1;
        }else{
            front++;
        }
        return val;
    }

    void display() throws StackExceptions {
        if(isEmpty()){
            throw new StackExceptions("Stack is Empty");
        }
        for (int i = front; i <=rear; i++) {
            System.out.print(data[i]+" --> ");
        }
        System.out.println();
    }

}


class Main2{
    public static void main(String[] args) throws StackExceptions {
        Queue que = new Queue();
        que.enQueue(23);
        que.enQueue(3);
        que.enQueue(16);
        que.enQueue(91);
        que.display();
        que.enQueue(2);
        que.display();

    }
}