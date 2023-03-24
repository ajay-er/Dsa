import java.util.Scanner;

public class fibonacci{
    public static void main(String[] args) {
        System.out.println("Enter a  number count for fibonacci");
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
            int n1 =0;int n2=1;
            int n3;
            System.out.print(n1+","+n2);
        for(int i=0;i<=n;i++){  
            
                n3 = n1 + n2;
                System.out.print(","+n3);
                n1 = n2;
                n2 = n3; 
        }
    }
}