class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;

        Arrays.sort(nums);
        int c=1, ans=1;

        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1])continue;
            else if(nums[i] == nums[i-1] + 1){
                c++;
                ans = Math.max(ans,c);
            }
            else{
                c=1;
            }
        }
        return ans;
    }
}