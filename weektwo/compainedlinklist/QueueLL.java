package compainedlinklist;

public class QueueLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public QueueLL() {
        this.front = null;
        this.rear = null;
    }

    void enQueue(int x) {
        Node temp = new Node(x);
        if (front == null) {
            front = temp;
            rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    void deQueue() {
        if (front == null) {
            rear = null;
            System.out.println("Queue is Empty");
            return;
        }

        if (front == rear) {
            // if there is only one element in the queue
            front = null;
            rear = null;
            return;
        }
        front = front.next;
    }

    void display() {

        if (front == null) {
            System.out.println("Empty Queue");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
