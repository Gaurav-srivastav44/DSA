class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans,-1);

        for(int i=0; i<2*n ;i++){
            int x = nums[i%n];
            while(!st.isEmpty() && nums[st.peek()] < x){
                int idx = st.pop();
                ans[idx] = x;
            }
            if(i<n) st.push(i);
        }
        return ans;
    }
}