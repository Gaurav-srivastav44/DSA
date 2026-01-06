class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;

        for (int p : prices) {
            int prevSold = sold;

            sold = hold + p;
            hold = Math.max(hold, rest - p);
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }
}