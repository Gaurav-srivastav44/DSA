class Solution {
    public String longestPalindrome(String s) {
        int n =s.length();
        int start=0;
        int end=0;

        for(int i=0; i<n; i++){

            int l1 = helper(s,i,i);
            int l2 = helper(s,i,i+1);
            int maxl = Math.max(l1,l2);

            if(maxl > end-start){
                start = i- (maxl-1)/2;
                end = i+ maxl/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int helper(String s,int l,int r){
        int n = s.length();
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            l--; r++;
        }
        return r-l-1;
    }
}