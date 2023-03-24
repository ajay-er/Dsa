package repeat.sortingagain;

import repeat.StackExceptions;

public class QueueInLL {
    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    QueueInLL() {
        this.front = null;
        this.rear = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enQ(int x) {
        Node temp = new Node(x);

        if (front == null) {
            front = temp;
            rear = temp;
            return;
        }

        rear.next = temp;
        rear = temp;
    }

    int deQ() throws StackExceptions {
        if (isEmpty()) {
            throw new StackExceptions("Stack is empty");
        }
        front = front.next;
        int val = front.data;
        if (rear == front) {
            front = null;
            rear = null;
        }
        if(front==null){
            rear = null;
        }
        return val;
    }

    void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println();
    }
}


class A{
    public static void main(String[] args) throws StackExceptions {
        QueueInLL one = new QueueInLL();
        one.enQ(2);
        one.enQ(23);
        one.enQ(21);
        one.display();
        one.enQ(4);
        one.display();
        one.enQ(29);
        one.display();
        one.deQ();
        one.deQ();
        one.display();        
    }
}