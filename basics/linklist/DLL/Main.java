public class Main{
    public static void main(String[] args) {
        DoublyLL list =new DoublyLL();
        list.insertFirst(34);
        list.insertFirst(92);
        list.insertFirst(67);
        list.insertFirst(90);
        list.insertLast(970);
        list.insert(77, 4);
        list.display();
        list.reverse();
    }
}