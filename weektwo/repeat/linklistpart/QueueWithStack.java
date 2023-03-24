// package repeat.linklistpart;

// import repeat.StackExceptions;

// public class QueueWithStack {
//    private StackLList one = new StackLList();
//    private StackLList two = new StackLList();

//     boolean isEmpty(){
//         return one.isEmpty();
//     }

//     void enQueue(int x){
//         one.push(x);
//     }

//     int deQueue() throws StackExceptions{
//         while(!one.isEmpty()){
//             two.push(one.pop());
//         }

//         int val = two.pop();

//         while(!two.isEmpty()){
//             one.push(two.pop());
//         }
//         return val;
//     }


// int peek() throws StackExceptions{
//     while(!one.isEmpty()){
//         two.push(one.pop());
//     }

//     int val = two.peek();

//     while(!two.isEmpty()){
//         one.push(two.pop());
//     }
//     return val;
//   }

//   void display(){
//     one.display();
//   }
// }

// class B{
//     public static void main(String[] args) throws StackExceptions {
//         QueueWithStack que = new QueueWithStack();
//         que.enQueue(23);
//         que.enQueue(9);
//         que.enQueue(98);
//         que.enQueue(8);
//         que.display();
//         que.enQueue(2);
//         // que.display();
//     }
// }