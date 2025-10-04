class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(candidates,target, 0,temp,ans);
        return ans;
    }
    private void dfs(int[] arr, int target, int s, List<Integer> path,List<List<Integer>> ans){
        
        int n=arr.length;
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=s; i<n; i++){
            if(i>s && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i] > target){
                break;
            }
            path.add(arr[i]);
            dfs(arr, target-arr[i], i, path, ans);
            path.remove(path.size()-1);
        }
    }
}