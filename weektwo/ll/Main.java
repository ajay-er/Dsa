package ll;

import ll.LinkedList.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertLast(3);
        list.insertLast(14);
        list.insertLast(2);
        list.insertLast(6);
        // list.insertLast(6);
        list.display();
        // list.bubbleSort();
        // list.B();
        // list.selectionSort();
        // list.display();
        // list.insert();
        // list.mergeSort();
        list.quickSort();
        list.display();
    }
}
