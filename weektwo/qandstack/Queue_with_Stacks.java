package qandstack;

import repeat.StackExceptions;

public class Queue_with_Stacks {
    Stack_LL one = new Stack_LL();
    Stack_LL two = new Stack_LL();

    boolean isEmpty() {
        return one.isEmpty();
    }

    void enQ(int x) {
        one.push(x);
    }

    int deQ() throws StackExceptions {
        while (!one.isEmpty()) {
            two.push(one.pop());
        }

        int val = two.pop();

        while (!two.isEmpty()) {
            one.push(two.pop());
        }
        return val;
    }

    int peek()throws StackExceptions {
        while (!one.isEmpty()) {
            two.push(one.pop());
        }

        int val = two.peek();

        while (!two.isEmpty()) {
            one.push(two.pop());
        }
        return val;
    }

    void display(){
        one.display();
    }

    public static void main(String[] args) throws StackExceptions {
        Queue_with_Stacks qs = new Queue_with_Stacks();
        qs.enQ(23);
        qs.enQ(86);
        qs.enQ(7);
        qs.enQ(75);
        qs.display();
        qs.deQ();
        qs.display();
        qs.enQ(175);
        qs.enQ(2);

        qs.display();
        qs.deQ();
        qs.display();



    }
}
