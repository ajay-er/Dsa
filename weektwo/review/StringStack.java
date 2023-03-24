package review;

import java.util.Stack;

public class StringStack {
    public String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str += stack.pop();
        }
        return str;
    }

    public static void main(String[] args) {
        StringStack s = new StringStack();
        String name = s.reverse("Ajay");
        System.out.println(name);
    }
}
