class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans =0;
        for(int i=0; i<nums.length; i++){
                ans += sumd(nums[i]);
        }
        return ans;
    }
    public int sumd(int n){
        int c=0; 
        int ans=0;
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                c++;
                ans += i;
            }
            if(c>4)return 0;
        }
        if(c==4)return ans;
        return 0;
    }
}