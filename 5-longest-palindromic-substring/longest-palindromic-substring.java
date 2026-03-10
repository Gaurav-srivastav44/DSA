class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int maxl =0;
        int n = s.length();
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                String sub = s.substring(i,j+1);

                if(check(sub) && sub.length()>ans.length()){
                    ans = sub;
                    maxl = sub.length();
                }
            }
        }
        return ans;
    }
    public boolean check(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}