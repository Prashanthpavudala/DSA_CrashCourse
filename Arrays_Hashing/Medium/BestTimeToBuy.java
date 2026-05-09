package Arrays_Hashing.Medium;

/*
    Input:
    prices = [7,1,5,3,6,4]

    Output:
    5

    Explanation:

    Day    Price    Action
    1      7        Skip
    2      1        Buy
    3      5        Profit = 4
    5      6        Profit = 5

    Maximum Profit:

    6 - 1 = 5
*/
public class BestTimeToBuy {
    
    // TC: O(n^2), SC: O(1)
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }
        return maxProfit;
    }


    // TC: O(n), SC: O(1)
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l=0, r=1;
        while(r < prices.length){
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            }else{
                l = r;
            }
            r++;
        }
        return maxProfit;
    }

    /*
        Dry run
            l=0, r=1
            profit=-6
            maxProfit=0 l=1, r=2
            
            l=1, r=2
            profit=4
            maxProfit=4 l=1 r=3
            
            l=1 r=3
            profit=2
            maxProfit=4 l=1 r=4

            l=1 r=4
            profit=5
            maxProfit=5 l=1 r=5

            l=1 r=5
            profit=3
            maxProfit=5
    */


    public static int maxProfitOpt(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
    /*
        Dry run
            maxProfit = 0;
            minPrice = 7;

            i = 1 profit = -6 maxProfit = 0 minPrice = 1
            i = 2 profit = 4 maxProfit = 4 minPrice = 1
            i = 3 profit = 2 maxProfit = 4 minPrice = 1
            i = 4 profit = 5 maxProfit = 5 minPrice = 1
            i = 5 profit = 3 maxProfit = 5 minPrice = 1
            
            final answer --- maxProfit=5
    */

    public static void main(String[] args) {

        // Example input
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Function call
        int result = maxProfitOpt(prices);

        // Output
        System.out.println("Maximum Profit: " + result);
    }
}
