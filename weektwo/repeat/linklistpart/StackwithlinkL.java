package repeat.linklistpart;

import repeat.StackExceptions;

public class StackwithlinkL {
    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Node top;

    StackwithlinkL() {
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

    void pop() throws StackExceptions {

        if (isEmpty()) {
            throw new StackExceptions("Stack is empty");
        }
        int val = top.data;
        top.next = top;
        System.out.println(top.data);
    }

    int peek() throws StackExceptions{
        if (isEmpty()) {
            throw new StackExceptions("Stack is empty");
        }
        return top.data;
    }

    void display(){
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        StackwithlinkL dd =new StackwithlinkL();
        dd.push(3);
        dd.push(3);
        dd.push(3);
        dd.display();
    }
}
