public class Main {
    public static void main(String args[])throws CustomException{
        CustomStack stack = new CustomStack(5);
        stack.push(56);
        stack.push(1);
        stack.push(65);
        stack.push(65);
        System.out.println(stack.push(32));
        System.out.println(stack.push(99));
        System.out.println(stack.push(99));

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
