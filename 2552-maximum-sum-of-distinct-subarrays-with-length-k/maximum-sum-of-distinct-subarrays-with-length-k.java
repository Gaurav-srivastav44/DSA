class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int i=0;
        HashSet<Integer> set = new HashSet<>();

        long sum=0;
        long ans=0;

        for(int j=0; j<n; j++){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            set.add(nums[j]);
            sum += nums[j];
            
            if(j-i+1 == k){
                ans = Math.max(ans, sum);
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }

        return ans;

    }
}