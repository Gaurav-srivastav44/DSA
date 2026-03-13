class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            if(nums[i] == 0)nums[i] = -1;
        }
        map.put(0,-1);

        int ans = 0;
        int sum =0;

        for(int j=0; j<n; j++){
            sum += nums[j];
            if(map.containsKey(sum)){
                ans = Math.max(ans , j-map.get(sum));
            }
            else map.put(sum, j);
        }
        return ans;
    }
}