class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int max=0;
        int csum=0;

        for(int i=0; i<n; i++)if(nums[i]==0)nums[i]=-1;
        
        for(int i=0; i<n; i++){
            csum += nums[i];
            if(map.containsKey(csum)){
                max = Math.max(max, i- map.get(csum));
            }
            else map.put(csum, i);
        }
        return max;

    }
}