class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length() == 0)return 0;
        char[] arr = s.toCharArray();
        int n =arr.length;

        int sign=1;
        int i=0;

        if(arr[0]=='-' || arr[0]=='+'){
            if(arr[0]=='-')sign =-1;
            i++;
        }

        long ans = 0;
        while(i<n && arr[i]>='0' && arr[i]<='9'){
            ans = ans*10 + (arr[i]-'0');
            i++;

            if(sign*ans > Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(sign*ans < Integer.MIN_VALUE)return Integer.MIN_VALUE;
        }

        return (int)(sign * ans);


    }
}