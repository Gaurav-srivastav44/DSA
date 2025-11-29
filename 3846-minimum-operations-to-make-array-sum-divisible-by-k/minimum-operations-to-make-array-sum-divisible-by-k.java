class Solution {
    public int minOperations(int[] nums, int k) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int ans = (int)(sum % k);
        return ans;
    }
}
