package DLL;

public class DoublyLL {
    public class Node{

        private int value;
        private Node next;
        private Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(int value) {
            this.value = value;
        }        
        
    }

    /* Code */
    private Node head;
    private Node tail;
    private int size;


    public void insertFirst(int val){

        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head!=null){
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val){
        if(head==null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val,int index){
        
        if(index == 0){
            insertFirst(val);
            return;
        }

        if(index == size){
            insertLast(val);
            return;
        }
        if(index>size){
           System.out.println("not exist index==> "+ index);
           return;
        }

        Node temp = head;
        for (int i = 1; i < index ; i++) {
            temp = temp.next;
        }        

        Node newNode = new Node(val,temp.next,temp.next.prev);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
           System.out.print(temp.value+" ==> ");
           temp = temp.next;
        }
        System.out.println("End");
    }

    public void reverse(){
        Node last = tail;
        while(last!=null){
            System.out.print(last.value+" --> ");
            last = last.prev;
        }
        System.out.println("Start");
    }
}
