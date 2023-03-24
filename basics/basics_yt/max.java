public class max {

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 3 },
                { 3, 5, 6 },
                { 3 },
                { 4, 6, 1, 3, 66 }
        };
         System.out.println(max(arr)); 
    }

    public static int max(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
}
