package compainedlinklist;

public class QuewithStack {
    StackLL one1;
    StackLL two1;

    QuewithStack() {
        one1 = new StackLL();
        two1 = new StackLL();
    }

    boolean isEmpty() {
        return one1.isEmpty();
    }

    void enQ(int x) {
        one1.push(x);
    }

    int deQ() {
        while (!one1.isEmpty()) {
            two1.push(one1.pop());
        }
        int value = two1.pop();
        while (!two1.isEmpty()) {
            one1.push(two1.pop());
        }
        return value;
    }

    int peek(){
        while (!one1.isEmpty()) {
            two1.push(one1.pop());
        }
        int value = two1.peek();
        while (!two1.isEmpty()) {
            one1.push(two1.pop());
        }
        return value;
    }

    void display(){
        one1.display();
    }


    public static void main(String[] args) {
        QuewithStack que = new QuewithStack();
        que.enQ(23);
        que.enQ(9);
        que.enQ(1);
        que.display();
        que.enQ(7);
        que.display();
        que.deQ();
        que.deQ();
        que.deQ();
        que.deQ();
        que.deQ();
        que.display();
    }
}
