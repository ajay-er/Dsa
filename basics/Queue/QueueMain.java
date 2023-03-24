public class QueueMain {

    public static void main(String ar[]) throws Exception{
    CustomQueuee queue = new CustomQueuee(5);
    queue.insert(46);
    queue.insert(5);
    queue.insert(9);
    queue.insert(63);
    queue.insert(123);
    queue.display();
    int f = queue.remove();
    System.out.println(f);
    queue.display();

    }
}
