class Solution {
    public int minNumberOperations(int[] target) {
        int ans =0;
        if(target[0] > target[1]){
            ans += target[0];
        }
        else ans += target[1];

        for(int i=1; i<target.length-1; i++){
            if(target[i+1] > target[i]){
                ans += target[i+1] - target[i];
            }
        }
        return ans;
    }
}