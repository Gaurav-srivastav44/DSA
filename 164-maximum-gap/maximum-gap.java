class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2)return 0;

        int ans =0;

        Arrays.sort(nums);
        for(int i=n-1; i>0; i--){
            ans = Math.max(ans, nums[i] - nums[i-1]);
        }

        return ans;
    }
}