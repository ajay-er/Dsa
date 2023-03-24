package Test.Polymorphism;

public class MainS {
   
    public static void main(String[] args) {
        Shape shape = new Shape();
        Shape sq = new Square();
        
        sq.area();
        System.out.println(sq.num);
    }
}
