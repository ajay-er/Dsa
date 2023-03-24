package LnkLsT;

public class LnkLst {
    private Node Head;
    private Node tail;
    private int size;


    public LnkLst(){
        this.Head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertLs(int val){
        Node node = new Node(val);

        if(tail == null){
            insertFs(val);
        }


    }

    public void insertFs(int val){
        Node node = new Node(val);
        node.next = Head;
        Head = node;
        if(Head == null){
            tail = Head;
        }
    }

    public void displayNodes(){
        Node temp = Head;
        while(temp!=null){
            System.out.print(temp.value+" --> ");
            temp = temp.next;
        }
        System.out.println("End");
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
