class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int l=0;
        int ans=0;
        long prod =1;
        for(int i=0;i<nums.length;i++){
            prod *= nums[i];
            while(prod >= k){
                prod /= nums[l++];
            }
            ans += i-l+1;
        }
        return ans;
    }
}