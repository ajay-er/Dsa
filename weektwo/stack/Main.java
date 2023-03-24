package stack;

public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack(5);

        //pushing
        stack.push(23);
        stack.push(33);
        stack.push(6);
        stack.push(98);


        //print
        stack.printStack();

        //poping out
        stack.pop();
        stack.printStack();

        //size
        System.out.println(stack.size());
    }
}
