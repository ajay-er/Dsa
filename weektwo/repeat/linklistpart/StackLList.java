package repeat.linklistpart;

import repeat.StackExceptions;

public class StackLList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    StackLList() {
        this.top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
    }

    int pop() throws StackExceptions {
        if (isEmpty()) {
            throw new StackExceptions("Stack is empty");
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    int peek() throws StackExceptions {
        if (isEmpty()) {
            throw new StackExceptions("Stack is empty");
        }
        return top.data;
    }

    void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ==> ");
            temp = temp.next;
        }
        System.out.println();
    }

}
