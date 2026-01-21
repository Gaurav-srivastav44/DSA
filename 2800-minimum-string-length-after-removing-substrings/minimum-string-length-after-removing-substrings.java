class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();

        for(char i : s.toCharArray()){
            if(!st.isEmpty()){
                char top = st.peek();
                if((top=='A' && i=='B') || (top=='C' && i=='D')){
                    st.pop();
                }
                else{
                    st.push(i);
                    continue;
                }
            }
            else{
                st.push(i);
            }
        }

        int ans = st.size();
        return ans;
    }
}