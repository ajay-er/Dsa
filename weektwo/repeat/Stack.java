package repeat;

public class Stack {
    private int[] data;
    private int capacity;
    private int top;
    private final static int DEFAULT_SIZE = 10;

    Stack(int size) {
        data = new int[size];
        capacity = size;
        top = -1;
    }

    Stack() {
        this(DEFAULT_SIZE);
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return capacity - 1 == top;
    }

    void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        data[++top] = val;
    }

    int pop() throws StackExceptions {
        if (isEmpty()) {
            throw new StackExceptions("Stack is Empty");
        }
        return data[top--];
    }

    int peek() throws StackExceptions {
        if (isEmpty()) {
            throw new StackExceptions("Stack is Empty");
        }
        return data[top];
    }
}



class Main{
    public static void main(String[] args) throws StackExceptions {
        Stack stack = new Stack();
        stack.pop();
        stack.push(23);
        stack.push(23);
       
        System.out.println( stack.isEmpty());
        System.out.println( stack.isFull());
        stack.isFull();
    }
}
