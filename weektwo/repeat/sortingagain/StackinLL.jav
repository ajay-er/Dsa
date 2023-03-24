public class StackinLL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    Node top;

    StackinLL(){
        this.top = null;
    }

    boolean isEmpty(){
        return top ==null;
    }

    void push(int x){
        Node temp = new Node(6);
        temp.next = top;
        top = temp;
    }
}