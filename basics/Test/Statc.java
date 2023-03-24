package Test;

public class Statc {
    public static void main(String[] args) {
       System.out.println(Test.name = "Ajay");
       
    }
}

class Test{ 

    static Test next;
    
   static String name;

    public Test(String name) {
        Test.name = name;
    }
    
}