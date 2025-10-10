class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int next =-1;
            boolean found = false;

            for(int j=0; j<nums2.length; j++){
                if (nums2[j] == nums1[i]){
                    found = true;
                }
                else if(found && nums2[j] > nums1[i]) {
                    next = nums2[j];
                    break;
                }
            }
            ans[i] = next;

        }
        return ans;
    }
}