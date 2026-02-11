class Solution {
    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int c=0;
        for(int i=0; i<n-1; i++){
            if(nums[i] != nums[i+1]){
                c++;
                nums[c] = nums[i+1];
            }
        }
        return c+1;
        
    }
}