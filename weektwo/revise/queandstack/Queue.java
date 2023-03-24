package revise.queandstack;

import repeat.linklistpart.QueueException;

public class Queue {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    Queue() {
        this.front = null;
        this.rear = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enQ(int x) {
        Node temp = new Node(x);
        if (front == null) {
            rear = temp;
            front = temp;
            return;
        }

        rear.next = temp;
        rear = temp;
    }

    int deQ() throws  QueueException {
        if (isEmpty()) {
            throw new QueueException("q is empty");
        }
        int val = front.data;
        if (front == rear) {
            front = null;
            rear = null;
            return val;
        }
        front = front.next;
        return val;
    }

    void display(){
        Node temp =front;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws QueueException  {
        Queue q =new Queue();
        q.enQ(2);
        q.enQ(9);
        q.enQ(7);
        q.enQ(5);
        q.display();
        q.deQ();
        q.display();
        q.enQ(231);
        q.display();
        q.deQ();
        q.display();



    }
}
