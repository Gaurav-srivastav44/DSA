class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(char i : s.toCharArray()){
            if(!st.isEmpty() && Math.abs(st.peek() - i)== 32){
                st.pop();
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