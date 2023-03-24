package Test;

public class OneInstance {

    private OneInstance (){
    }

    private static OneInstance instance;

    public static OneInstance getInstance(){
        if(instance == null){
            instance = new OneInstance();
        }
        return instance;
    }
    
    public static void main(String[] args) {
        OneInstance one =  OneInstance.getInstance();
        System.out.println(one);
        OneInstance two =  OneInstance.getInstance();

        

    }
}
