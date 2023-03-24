    public class findWealth {
        public static void main(String[] args) {
            int [][] accounts = {
                {1,3,6},{1,3,6},{4,1}
            };
            
            System.out.println("Wealth of richest person"+maximumWealth(accounts));
        }

        public static int maximumWealth(int[][] accounts){
            int ans = Integer.MIN_VALUE;
            for (int row = 0; row < accounts.length; row++) {
                int max = 0;
                for (int col = 0; col < accounts[row].length; col++) {
                    max += accounts[row][col]; 
                }
                if(max > ans){
                    ans = max;
                }
            }
            return ans; 
        }
    }
