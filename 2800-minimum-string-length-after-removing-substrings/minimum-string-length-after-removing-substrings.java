class Solution {
    public int minLength(String s) {
        int len =-1;
        while(s.length() != len){
            len = s.length();
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }

        return s.length();
    }
}