package review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    static Queue<Integer> reverse(Queue<Integer> que){
    Stack<Integer> stk = new Stack<>();
       

        while(!que.isEmpty()){
            stk.push(que.remove());
        }

        while(!stk.isEmpty()){
            que.add(stk.pop());
        }
        return que;
    }

    static public void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(23);
        que.add(32);
        que.add(1);
        que.add(6);
        Queue v = reverse(que);
        System.out.println(v);
    }
}
