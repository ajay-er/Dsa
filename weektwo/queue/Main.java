package queue;

public class Main {

  public static void main(String[] args) {
    Queue q = new Queue(6);
    q.enQueue(34);
    q.enQueue(334);
    q.enQueue(3423);
    q.enQueue(324);

    q.display();

    System.out.println(q.deQueue());
    q.display();

    System.out.println(q.deQueue());
    q.display();

    System.out.println(q.deQueue());
    q.display();
    System.out.println(q.deQueue());
    q.display();

    System.out.println(q.deQueue());
    q.display();

    q.enQueue(23324);
    System.out.println(q.deQueue());
  }
}
