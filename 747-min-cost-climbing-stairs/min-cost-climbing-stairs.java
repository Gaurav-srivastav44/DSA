class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, dp, 0), helper(cost, dp , 1));
    }
    public int helper(int[] arr, int[] dp, int i){
        int n = arr.length;
        if(i>=n)return 0;

        if(dp[i] != -1)return dp[i];

        int one = arr[i] + helper(arr, dp ,i+1);
        int two = arr[i] + helper(arr, dp ,i+2);

        dp[i] = Math.min(one, two);
        return dp[i];
    }
}