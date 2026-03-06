class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] alpha = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, alpha, 0, ans, "");
        return ans;
    }

    public List<String> helper(String digits, String[] alpha, int idx, List<String> ans, String curr){
        if(idx == digits.length()){
            ans. add(curr);
            return ans;
        }

        int num = digits.charAt(idx) - '0';
        char[] arr = alpha[num].toCharArray();

        for(char i: arr){
            String temp = curr;
            curr += ""+i;
            helper(digits, alpha, idx+1, ans, curr);
            curr = temp;
        }
        return ans;
    }
}