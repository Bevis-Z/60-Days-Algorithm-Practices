class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, (prices[i] - prices[i - 1]));
        }
        return res;
    }
}