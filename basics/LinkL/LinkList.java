public class LinkList{
    
public class LnkLst {
    private Node head;
    private Node tail;
    private int size;


    public LinkList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public static void insertFs(int val){
        Node node = new Node(val);
        node.next = head;
        if(Head == null){

        }

    }


    public class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value,Node next){
            this.next = next;
            this.value = value;
        }
    }
}

}