class Solution {
    public int maxProfit(int[] prices) {
        int pointer1 = 0;
        int pointer2 = 1;
        int profit = 0;
        
        while(pointer2 < prices.length) {
            if(prices[pointer1] < prices[pointer2]) {
                profit = Math.max(profit, prices[pointer2] - prices[pointer1]);
            }
            else {
                pointer1 = pointer2;
            }
            pointer2++;
        }

        return profit;
    }

}
