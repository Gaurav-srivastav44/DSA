class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<n && j<m){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])i++;
            else j++;
        }

        int l = list.size();
        int[] ans = new int[l];
        int p=0;
        for(int x : list){
            ans[p++] = x;
        }

        return ans;

    }
}