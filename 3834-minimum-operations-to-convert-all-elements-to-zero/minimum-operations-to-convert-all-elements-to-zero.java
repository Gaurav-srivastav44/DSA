class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (int x : nums) {
            while (!st.isEmpty() && st.peek() > x) st.pop();
            if (st.peek() < x) {
                ans++;
                st.push(x);
            }
        }
        return ans;
    }
}
