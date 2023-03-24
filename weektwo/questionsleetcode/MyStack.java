// package questionsleetcode;

// class MyStack {
    
//     private int[] primaryArray;
//     private int[] secondaryArray;
//     private int top;

//     public MyStack() {
//         primaryArray = new int[100];
//         secondaryArray = new int[100];
//         top = -1;
//     }

//     public void push(int x) {
//         secondaryArray[++top] = x;
    
//         while (top > 0) {
//             primaryArray[top - 1] = secondaryArray[top];
//             top--;
//         }
    
//         int[] temp = primaryArray;
//         primaryArray = secondaryArray;
//         secondaryArray = temp;
//         top = primaryArray.length - 1;
//     }
    

//     public int pop() {
//     if (top == -1) {
//         throw new RuntimeException("Stack is empty");
//     }
//     return primaryArray[top--];
// }


//     public int top() {
//         return primaryArray[top];
//     }

//     public boolean empty() {
//         return top == -1;
//     }
// }

// class MainC{
//     public static void main(String[] args) {
//         MyStack stack = new MyStack();
//         stack.push(2);
//     }
// }