package questions;

import stack.*;

//queue using stacks

public class myQ {
   
    private Stack one;
    private Stack two; 

    myQ(int value){
        one = new Stack(value);
        two = new Stack(value);
    }

    public void push(int x){
            one.push(x);
    } 

    public int pop(){
        while(!one.isEmpty()){
            two.push(one.pop());
        }
        int erase = two.pop();
        while(!two.isEmpty()){
            one.push(two.pop());
        }
        return erase;
    }

    public int peek(){
        while(!one.isEmpty()){
            two.push(one.pop());
        }
        int val = two.peek();
        while(!two.isEmpty()){
            one.push(two.pop());
        }
        return val;
    }

    public boolean isEmpty(){
        return one.isEmpty();
    }

    public boolean isFull(){
        return one.isFull();
    }
}

class Main{
    public static void main(String[] args) {
        myQ queue = new myQ(5);
        queue.pop();
        queue.push(3);
        queue.push(233);
        queue.push(35);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        
    }
}