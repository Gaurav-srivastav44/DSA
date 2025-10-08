class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int c=1;
        int start = nums[0];
        for(int i : nums){
            if(i-start > k){
                c++;
                start = i;
            }
        }
        return c;
    }
}