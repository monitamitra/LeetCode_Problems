class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int buy_price = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy_price) {
                // finding lowest price to buy stock on
                buy_price = prices[i];
            } else if (prices[i] - buy_price > max_profit) {
                // attempts to find highest profit
                // prices[i] is curr price to sell stock on
                max_profit = prices[i] - buy_price;
            }
        }

        return max_profit;
    }
}