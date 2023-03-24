package revise.queandstack;

import repeat.StackExceptions;

public class Stack {
    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Node top;

    Stack() {
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
            throw new StackExceptions("stack is empty");
        }

        int val = top.data;
        top = top.next;
        return val;
    }

    void display() {
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws StackExceptions {
        Stack s =new Stack();
        s.push(23);
        s.push(6);
        s.push(3);
        s.push(2);
        s.display();
        s.pop();
        s.display();
        s.pop();
        s.display();
        s.push(29);
        s.display();
    
    }
}
