package LL;

public class LLmain {
    public static void main(String[] args) {
        LinkLinst list = new LinkLinst();

        list.insertFirst(3);
        list.insertFirst(29);
        list.insertLast(121);
        list.display();
        list.delete(3);
        list.display();

        //convert array to ll
        int[] arr = {91,92,32,41,87,66};
        for (int i = 0; i < arr.length; i++) {
            list.insertFirst(arr[i]);
        }
       
    }
}
