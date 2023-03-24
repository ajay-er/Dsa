package review;

import java.util.Stack;

public class MiddileElementInStack {
    public static Integer findAndRemoveMid(Stack<Integer> stck){
            int size = stck.size();
            
            int mid  = size/2;

            Stack<Integer> str2 = new Stack<>(); 

            for (int i = 0; i < mid; i++) {
                str2.push(stck.pop());
            }

            int removed = stck.pop();
            
            for (int i = mid-1; i>=0; i--) {
                stck.push(str2.pop());
            }
           return removed;
    }

    public static void main(String[] args) {
        Stack<Integer> stck = new Stack<>();
        stck.push(3);
        stck.push(32);
        stck.push(23);
        stck.push(92);
        findAndRemoveMid(stck);
        System.out.println(stck);
        findAndRemoveMid(stck);
        System.out.println(stck);

    }
}
