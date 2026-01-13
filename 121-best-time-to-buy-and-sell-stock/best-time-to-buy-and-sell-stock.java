class Solution {
    public int maxProfit(int[] prices) {
        int maxp =0;
        int best = prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i] < best){
                best = prices[i];
            }
            else{
                maxp = Math.max(maxp, prices[i]-best);
            }
        }
        return maxp;
    }
}