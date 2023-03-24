package CircularQ;

public class CircularMain {

    public static void main(String[] args) throws Exception {
    CircularQueue queue = new CircularQueue(5);
        queue.insert(23);
        queue.insert(11);
        queue.insert(123);
        queue.insert(98);
        queue.insert(77);
        queue.insert(88);
        queue.display();
        queue.remove();
        queue.display();
    }
}
