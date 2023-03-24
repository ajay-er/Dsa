package questions;

public class QueueBuild {
    private int[] data;
    private int rear;
    private int front;
    private int capacity;

    QueueBuild(int size) {
        data = new int[size];
        rear = -1;
        front = -1;
        capacity = size;
    }

    void enQueue(int x) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        data[++rear] = x;
    }

    int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int ErasedVal = data[front];
        if (rear == front) {
            rear = -1;
            front = -1;
        } else {
            front++;
        }
        return (ErasedVal);
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        return capacity - 1 == rear && front == 0;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Empty queue");
        } else {
            System.out.println("displaying --> ");
            for (int i = front; i <= rear; i++) {
                System.out.println(data[front] + "--> ");
            }
            System.out.println("End");
        }
    }

    public static void main(String[] args) {
        QueueBuild q = new QueueBuild(5);

        q.enQueue(34);
        q.enQueue(344);
        q.enQueue(7);
        q.enQueue(634);
        System.out.println(q.deQueue());
    }   

}
