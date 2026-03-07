class Solution{
    public int minFlips(String s){
        int n=s.length();
        String t=s+s;
        int alt1=0,alt2=0;
        int res=Integer.MAX_VALUE;
        int i=0;

        for(int j=0;j<t.length();j++){
            char c=t.charAt(j);

            if(c!=(j%2==0?'0':'1'))alt1++;
            if(c!=(j%2==0?'1':'0'))alt2++;

            if(j-i+1>n){
                char left=t.charAt(i);

                if(left!=(i%2==0?'0':'1'))alt1--;
                if(left!=(i%2==0?'1':'0'))alt2--;

                i++;
            }

            if(j-i+1==n){
                res=Math.min(res,Math.min(alt1,alt2));
            }
        }

        return res;
    }
}