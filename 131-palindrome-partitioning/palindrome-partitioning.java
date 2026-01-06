class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(ans, temp, s, 0);
        return ans;
    }

    public void helper(List<List<String>> ans, List<String> temp, String s, int idx){
        if(idx == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            if(isPall(s,idx,i)){
                temp.add(s.substring(idx,i+1));
                helper(ans, temp, s, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPall(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}