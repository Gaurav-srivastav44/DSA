class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fn(nums, dp, 0);
    }

    public int fn(int[] nums, int[] dp, int i){
        int n= nums.length;
        if(i>=n)return 0;

        if(dp[i] != -1)return dp[i];

        dp[i] = Math.max(fn(nums,dp,i+1) , (nums[i]+fn(nums,dp,i+2)));
        return dp[i];
    }
}