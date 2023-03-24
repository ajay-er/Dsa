package Test;

public class Box {

    private double l ;
    double h;

    public Box(double l , double h){
        this.l = l;
        this.h = h;
    }

    public Box(Box one){
        this.h = one.h;
        this.l = one.l;
    }

    public static void main(String[] args) {
        Box box1 = new Box(2.2,35.2);
        System.out.println(box1.h+" ==> "+box1.l);
        Box box2 = new Box(box1);
        System.out.println(box2.h+" ==> "+box2.l);


    }


}
