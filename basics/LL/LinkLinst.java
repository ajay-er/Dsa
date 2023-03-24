package LL;

public class LinkLinst {

    private Node head;
    private Node tail;
    private int size;

    public void LL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (head == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void delete(int val){
       Node temp = head;
       Node prev = null;

       if(temp==null){
        System.out.println("Empty list");
         return;
       }

       if (temp != null && temp.value == val) {
        head = temp.next;
        return;
       }

       while(temp!=null && temp.value!=val){
        prev = temp;    
        temp = temp.next;
       }
       prev.next = temp.next;
      
    }
   

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.next = next;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }
    }

}
