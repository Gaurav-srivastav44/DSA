class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int ans = 0;
        int i=0;
        while(i<n){
            int zero = 0;
            for(int j=i; j<n; j++){
                if(nums[j] == 0)zero++;
                if(zero > k)break;
                ans = Math.max(ans , j-i+1);
            }
            i++;
        }
        return ans;
    }
}