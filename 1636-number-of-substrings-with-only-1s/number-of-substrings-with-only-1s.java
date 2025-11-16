class Solution {
    public int numSub(String s) {
        char[] arr = s.toCharArray();
        long c=0, cnt=0;
        long mod = 1_000_000_007;

        for(char i : arr){
            if(i - '0' == 1){
                c++;
                cnt += c;
            }
            else{
                c=0;
            }  
        }
        return (int)(cnt%mod);
        
    }
}