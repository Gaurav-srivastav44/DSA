class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n= piles.length;
        int l=1;
        int r=0;
        for(int i :piles){
            r = Math.max(r,i);
        }

        while(l<r){
            int mid = l+(r-l)/2;
            int total =0;

            for(int i=0; i<n; i++){
                total += (int)Math.ceil((double)piles[i]/mid);
            }

            if(total > h){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
}