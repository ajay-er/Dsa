package stack;

import queue.Queue;
import repeat.StackExceptions;

public class Stack {

    private int[] arr;
    private static int top;
    private static int capacity;

    public Stack(int size) {
        this.arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack is full");
            System.exit(1);
        }
        arr[++top] = x;
        // System.out.println("item " + x + " inserted");
    }

    public static boolean isFull() {
        return top == capacity - 1;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            System.exit(1);
        }
        int Erase = arr[top];
        // System.out.println("Item " + Erase + " removed");
        top--;
        return Erase;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("can't peek from Empty stack");
            return -1;
        }
        return arr[top];
    }

    public static boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public int size() {
        return top + 1;
    }

    public int removeMid() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        int size = size();
        int mid = size / 2;
        Stack temp = new Stack(capacity);
        for (int i = 0; i < mid; i++) {
            temp.push(pop());
        }

        int val = pop();

        for (int i = mid - 1; i >= 0; i--) {
            push(temp.pop());
        }
        return val;
    }

    public String reverseString(String str) {
        for (int i = 0; i < str.length(); i++) {
            push(str.charAt(i));
        }
        printStack();
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            newString += (char) pop();
        }
        return newString;
    }

    public static void reverseQueue(Queue tempQ) throws StackExceptions {

        Stack stck = new Stack(10);

        while (!tempQ.isEmpty()) {
            stck.push(tempQ.deQueue());
        }

        while (!stck.isEmpty()) {
            tempQ.enQueue(stck.pop());
        }

    }

    public static void main(String[] args) throws StackExceptions {
        // Stack s = new Stack(7);
        // s.push(23);
        // s.push(2);
        // s.push(1);
        // s.push(9);
        // s.push(99);
        // s.printStack();
        // System.out.println(s.removeMid());
        // s.printStack();
        // s.removeMid();
        // s.printStack();
        // s.removeMid();
        // s.printStack();

        // Stack one = new Stack(9);
        // String n = one.reverseString("ajay");
        // System.out.println(n);

        // Queue tempQ = new Queue(10);
        // tempQ.enQueue(1);
        // tempQ.enQueue(2);
        // tempQ.enQueue(3);
        // tempQ.enQueue(4);
        // reverseQueue(tempQ);
        // Stack s = new Stack(10);
        // s.printStack();

    }
}
