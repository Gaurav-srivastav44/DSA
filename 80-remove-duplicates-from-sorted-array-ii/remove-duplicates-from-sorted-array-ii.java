class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
            set.add(i);
        }

        int c=0;
        int p=0;
        for(int i : set){
            if(map.get(i) > 1){
                c+=2;
                nums[p++] = i;
                nums[p++] = i;
            }
            else{
                c++;
                nums[p++] = i;

            }
        }

        return c;
    }
}