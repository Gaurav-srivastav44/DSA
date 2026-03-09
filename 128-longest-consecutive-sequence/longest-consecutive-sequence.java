class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        int c=1, ans=1;

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i:nums)set.add(i);

        ArrayList<Integer> list = new ArrayList<>(set);

        int n =list.size();
        for(int i=1; i<n; i++){
            if(list.get(i) == list.get(i-1)+1){
                c++;
                ans = Math.max(ans,c);
            }
            else{
                c=1;
            }
        }
        return ans;
    }
}