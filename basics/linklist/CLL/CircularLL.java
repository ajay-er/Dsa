public class CircularLL {
    public class Node{
        
        private int value;
        private Node next;

        public Node(int value, CircularLL.Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CircularLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val){
        Node node = new Node(val);
        
        if(head==null){
            head = node;
            tail =node;
            return; 
        }
        tail.next = node;
        node.next = head;
        tail = node;

    }
    
    public void display(){
        Node temp = head;
        if(head != null){

            do{
                System.out.print(temp.value + " ==> ");
                temp = temp.next;
            } while(temp!=head);
        }
    }
}
