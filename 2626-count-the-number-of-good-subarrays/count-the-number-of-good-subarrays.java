class Solution {
    public long countGood(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0;
        long pair=0;
        long ans =0;

        for(int j=0; j<n;j++){
            pair += map.getOrDefault(nums[j], 0);
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            while(pair >= k){
                ans += n-j;
                map.put(nums[i], map.getOrDefault(nums[i],0)-1);
                pair -= map.get(nums[i]);
                i++;
            }
        }

        return ans;

    }
}