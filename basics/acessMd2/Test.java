package acessMd2;

import acessMd.PublicClass;

public class Test extends PublicClass {
    // public static void main(String[] args) {
    //     Test s2 = new Test();
        
    // }
}


class Sup extends Test{
    public static void main(String[] args) {
        Sup s = new Sup();
        s.method();
    }
    
}
