package compainedlinklist;

public class MainLlTest {
    public static void main(String[] args) {
     

        // StackLL stack = new StackLL();
        // stack.push(3);
        // stack.push(233);
        // stack.push(4);
        // stack.display();
        // stack.pop();
        // stack.display();



        QueueLL q = new QueueLL();
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(6);
        q.display();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.display();

        
    }
}
