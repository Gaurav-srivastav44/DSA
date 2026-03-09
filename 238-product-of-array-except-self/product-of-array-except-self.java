class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int c=0;
        int prod=1;
        int idx=-1;

        for(int i=0; i<n; i++){
            if(nums[i]==0){
                c++;
                idx = i;
            }
            else{
                prod *= nums[i];
            }
        }

        if(c>1){
            Arrays.fill(ans,0);
            return ans;
        }

        else if(c==1){
            Arrays.fill(ans,0);
            ans[idx]=prod;
            return ans;
        }

        for(int i=0; i<n; i++){
            ans[i] = prod/nums[i];
        }
        return ans;

    }
}