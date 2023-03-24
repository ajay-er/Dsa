package compainedlinklist;

import java.util.EmptyStackException;

import ll.Main;

public class StackLL {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    StackLL() {
        this.top = null;
    }

    void push(int x) {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
    }

    int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int item = top.data;
        top = top.next;
        return item;
    }

    int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    boolean isEmpty() {
        return top == null;
    }

    void display(){
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.print("End");
        System.out.println();
    }

    public static void main(String[] args) {
    StackLL dd =new StackLL();
        dd.push(232);
        dd.push(231);
        dd.push(23);
        dd.display();
        dd.pop();
        dd.display();
    }
}
