class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                for(int j=1; j<=k && i+j<n; j++){
                    if(nums[i+j] == 1)return false;
                }
            }
        }
        return true;
    }
}