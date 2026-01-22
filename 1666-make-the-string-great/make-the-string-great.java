class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(char i : s.toCharArray()){
            if(!st.isEmpty()){
                char top = st.peek();
                char c1 = Character.toLowerCase(i);
                char c2 = Character.toLowerCase(top);
                if(c1 == c2 && i != top){
                    st.pop();
                }
                else {
                    st.push(i);
                }
            }
            else{
                st.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}