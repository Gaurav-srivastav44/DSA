class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int sum=0;
        int ans= Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum >= target){
                ans = Math.min(ans , i-l+1);
                sum -= nums[l++];
            }
        }
        if(ans == Integer.MAX_VALUE) return 0;
        else return ans;
        
    }
}