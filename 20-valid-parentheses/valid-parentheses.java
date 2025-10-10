class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr  = s.toCharArray();

        for(char i : arr){
            if(i == '(' || i == '[' || i == '{'){
                st.push(i);
            }
            else{
                if(st.isEmpty()) return false;
                else if(i == ')' && st.peek() == '(') st.pop();
                else if(i == ']' && st.peek() == '[') st.pop();
                else if(i == '}' && st.peek() == '{') st.pop();
                else return false;
            }
            
        }

        return st.isEmpty();
    }
}