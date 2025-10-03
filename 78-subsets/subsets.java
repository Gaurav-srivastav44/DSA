class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        int i=0;

        helper(nums,ans,temp,i);
        
        return ans;
    }

    private void helper(int[] arr, List<List<Integer>> ans, List<Integer> temp, int i){
        if(i == arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(arr[i]);
        helper(arr,ans,temp,i+1);

        temp.remove(temp.size()-1);
        helper(arr,ans,temp,i+1);
    }
}