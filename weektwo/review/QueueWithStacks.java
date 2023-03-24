package review;

public class QueueWithStacks {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    QueueWithStacks() {
        this.top = null;
    }

    boolean isEmpty(){
        return top == null;
    }

    void push(int x){
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
    }

    int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    void display(){
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueWithStacks s = new QueueWithStacks();
        s.push(73);
        s.push(93);
        s.push(9);
        s.push(1);
        s.push(32);
        s.display();
        s.pop();
        s.display();
    }
}

