import java.util.Arrays;

public class stringSearch {
    public static void main(String[] args) {
        String name = "Ajay";
        char target = 'j';
        System.out.println(Search(name, target));

        System.out.println(Arrays.toString(name.toCharArray()));

    }


     //for each
     static boolean Search(String name,char target){
        if(name.length() == 0){
            return false;
        }

        
        for (char str : name.toCharArray()) {
            if(str == target){
                return true;
            }
        }
        return false;
    }





    // static boolean Search(String name,char target){
    //     if(name.length() == 0){
    //         return false;
    //     }

    //     for (int i = 0; i < name.length(); i++) {
    //         if(target == name.charAt(i)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }


   
}
