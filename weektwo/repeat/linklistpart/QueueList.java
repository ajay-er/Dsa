package repeat.linklistpart;

public class QueueList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    QueueList() {
        this.front = null;
        this.rear = null;
    }

    boolean isEmpty() {
        return front == null;
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
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        if (rear == front) {
            rear = null;
            front = null;
            return;
        }
        front = front.next;
    }


    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
       return front.data;
    }

    void display(){
        Node temp = front;
        while(temp!=null){
            System.out.print(temp.data + " ---> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class MainQL{
    public static void main(String[] args) {

        QueueList ql = new QueueList();
        ql.enQueue(23);
        ql.enQueue(98);
        ql.enQueue(7);
        ql.display();
        ql.deQueue();
        ql.display();
        ql.enQueue(6);
        ql.display();

                
    }
}
