package qandstack;

import repeat.StackExceptions;

public class Stack_LL {
    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    Stack_LL() {
        this.top = null;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(int value) {
        Node temp = new Node(value);
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
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws StackExceptions {
        Stack_LL st = new Stack_LL();
        st.push(23);
        st.push(2);
        st.push(3);
        st.push(8);
        st.display();
        st.pop();
        st.display();

    }
}
