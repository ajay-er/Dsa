package Test;

public class Best {
    Best(){
        System.out.println("Hie");
    }
    
    int s = 0;
    Best(int s , int s1,int s2){
        System.out.print("hellloo"+s2);
    }
    
}

class BestOne extends Best{
    int ss =1;
    BestOne(){
        System.out.print("Koooii");
    }

    BestOne(int s , int s1,int s2){
        super(2,3,6);
        System.out.print("hellloo"+s2);
    }

    BestOne(int s){
        this(2,6,0);
        System.out.println("Hiiiiii");
    }

   
}

class Besttwo extends BestOne{

}

