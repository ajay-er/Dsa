package qandstack;

import repeat.StackExceptions;

public class Queue_LL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    Queue_LL() {
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

    int deQ() throws StackExceptions {
        if (isEmpty()) {
            throw new StackExceptions("can't delete from empty Stack ");
        }

        int val = front.data;
        if (rear == front) {
            rear = null;
            front = null;
            return val;
        }
        front = front.next;
        return val;
    }

    void display(){
        Node temp = front;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws StackExceptions {
        Queue_LL qe = new Queue_LL();
        qe.enQ(23);
        qe.enQ(6);
        qe.enQ(9);
        qe.enQ(7);
        qe.display();
        qe.deQ();
        qe.display();
        qe.enQ(97);
        qe.display();
        qe.deQ();
        qe.display();
    }

}
