package questions;
import queue.Queue;

public class MyS {
    Queue one;
    Queue two;
    
    MyS(int size){
        one = new Queue(size);
        two = new Queue(size);
    }

    void push(int x){
        one.enQueue(x);
    }

    // int pop(){
    //     while(!one.isEmpty()){
    //         two.enQueue(one.deQueue());
    //     }

        

    }


