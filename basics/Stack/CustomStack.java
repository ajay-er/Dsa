public class CustomStack{
        protected int[] data;
        private static final int DEFAULT_SIZE=10;

        int ptr = -1;

        public CustomStack(){
            this(DEFAULT_SIZE);
        }

        public CustomStack(int size) {
            this.data = new int[size];   
        }


        public boolean push(int item){
            if(isFull()){
                System.out.println("Stack is full");
                return false;
            }
            ptr++;
            data[ptr] = item;
            return true;
        }

        public int pop() throws CustomException{
            if(isEmpty()){
                throw new CustomException("Stack is Empty");
            }
            int removed = data[ptr];
            ptr--;
            return removed;
        }

        public int peek()throws CustomException{//what is at the top
            if(isEmpty()){
                throw new CustomException("cannot peek from Empty stack");
            }
            return data[ptr];
        }

        public boolean isFull(){
            return ptr == data.length-1;//pointer at last index
        }

        public boolean isEmpty(){
            return ptr == -1;
        }
}


