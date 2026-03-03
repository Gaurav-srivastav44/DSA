class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int a = helper(nums, 0, dp, n-2);

        Arrays.fill(dp, -1);
        int b = helper(nums, 1, dp, n-1);

        return Math.max(a,b);   

    }
    public static int helper(int[] nums, int i, int[] dp, int end){
        if(i > end)return 0;

        if(dp[i] != -1)return dp[i];

        int take = nums[i] + helper(nums, i+2, dp, end);
        int skip = helper(nums, i+1, dp, end);

        return dp[i] = Math.max(take, skip);

    }
}