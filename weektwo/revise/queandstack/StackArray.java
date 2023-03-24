package revise.queandstack;

public class StackArray {
    private int[] arr;
    private int top;
    private int capacity;

    StackArray(){
        this.capacity = 10;
        this.arr = new int[capacity];
        this.top = -1;
    }

    boolean isEmpty(){
        return top==-1;
    }

    boolean isFull(){
        return top==capacity-1;
    }

    void push(int x){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = x;
    }

    int pop(){
        if(isEmpty()){
            System.out.println("STack is Empty");
            return -1;
        }
        return arr[top--];
    }

    void display(){
        if(isEmpty()){
            System.out.println("STack is Empty");
            return;
        }

        for(int j = 1; j <= 2; j++) {
            for (int i = top; i >=0; i--) {
                System.out.print(arr[i]+" ==> ");
            }
        }
    }

    public static void main(String[] args) {
        StackArray s = new StackArray();
        s.push(223);
        s.push(3);
        s.push(8);
        s.push(28);
        s.display();
    }

}
