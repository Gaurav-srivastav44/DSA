class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int l = 1<<nums.length; // ya 2^n ie(Math.pow);

        for(int i=0; i<l ;i++){
            List<Integer> cur=new ArrayList<>();
            
            for(int j=0;j<nums.length;j++){
                int k = 1<<j;
                if((i&k) > 0){
                    cur.add(nums[j]);
                }
            }

            res.add(cur);
        }
        return res;
    }
}