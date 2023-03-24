package compainedlinklist;

public class QwithStack {
    StackLL one;
    StackLL two;
    
    QwithStack(){
        one = new StackLL();
        two = new StackLL();
    }

    void push(int x){
        one.push(x);
    }

    int pop(){
       while(!one.isEmpty()){
        two.push(one.pop());
       }

       int erase = two.pop();

       while(!two.isEmpty()){
            one.push(two.pop());
       }
       return erase;
    }

    void peek(){
        while(!one.isEmpty()){
         two.push(one.pop());
        }
 
        int erase = two.peek();
 
        while(!two.isEmpty()){
             one.push(two.pop());
        }
       System.out.println(erase);
     }

     void display(){
        one.display();
     }

     public static void main(String[] args) {
        QwithStack q = new QwithStack();
        q.push(23);
        q.pop();
        q.push(34);
        q.push(1);
        q.push(67);
        q.push(5);
        q.pop();
        q.display();
        q.push(53);
        q.display();
        q.peek();
        
     }
}
