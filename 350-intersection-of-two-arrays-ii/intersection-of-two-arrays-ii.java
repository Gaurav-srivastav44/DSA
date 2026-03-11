class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : nums2){
            if(map.containsKey(i) && map.get(i)>0){
                ans.add(i);
                map.put(i, map.get(i)-1);
            }
        }

        int n = ans.size();
        int p=0;
        int[] arr = new int[n];
        for(int i: ans){
            arr[p++] = i;
        }

        return arr;
    }
}