import org.w3c.dom.Node;

public class main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(32);
        list.insertFirst(100);
        list.insertFirst(9);
        list.insertFirst(88);
        list.insertLast(5);
        list.insert(2, 323);
        list.display();
        System.out.println("this value deleted==> "+list.deleteFirst());
        list.display();
        
        System.out.println("this last value deleted==> "+list.deleteLast());
        list.display();

        System.out.println("this middile value deleted==>"+list.delete(2));
        list.display();
        System.out.println(list.find(323));
        
        
        
    
    }       
}
