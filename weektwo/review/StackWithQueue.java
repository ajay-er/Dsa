package review;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    boolean count = true;
    void push(int x) {
        q1.add(x);
    }

    int pop() {
        while (q1.size() < 1) {
            q2.add(q1.remove());
        }
        int last = q1.remove();
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
        count = false;
        return last;
    }

    void display(){
        if(count){
            System.out.println(q1);
        }else{
            System.out.println(q2);
        }

        count = true;
    }

    public static void main(String[] args) {
        StackWithQueue st = new StackWithQueue();
        st.push(2);
        st.push(23);
        st.push(24);
        st.push(25);
        st.display();
        st.pop();
        st.display();
    }

}
