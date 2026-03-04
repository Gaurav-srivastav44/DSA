class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0; for(int i:nums)sum+=i;
        if(sum%2 != 0)return false;

        int target = sum/2;

        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        
        return helper(0, nums, target, dp);
    }
    public boolean helper(int i, int[] nums, int target, int[][] dp){
        if(i == nums.length || target<0)return(target == 0);

        if(dp[i][target] != -1){
            return (dp[i][target]==1);
        }

        if(target < 0)return false;
        boolean skip = helper(i+1, nums, target, dp);
        boolean pick = helper(i+1, nums, target-nums[i], dp);

        dp[i][target] = (skip||pick) ? 1 : 0;

        return(skip || pick);

    }
}