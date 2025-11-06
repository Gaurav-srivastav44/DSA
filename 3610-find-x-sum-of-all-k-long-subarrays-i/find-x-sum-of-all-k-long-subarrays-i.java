import java.util.*;
class Solution {
    public int[] findXSum(int[] nums,int k,int x) {
        int n=nums.length;
        int[] ans=new int[n-k+1]; //n-k+1 number of window ke liye
        Map<Integer,Integer> freq=new HashMap<>();

        //Ye PriorityQueue sabse zyada freq aur badi value(*agar freq same hai) wale element ko top pe rakhti hai.
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return b[0]-a[0];
            else  return b[1]-a[1];
        });

        //Pehle k elements iterate karke freq map fill kara
        for(int i=0; i<k; i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }

        ///loop for har possible window 
        for(int i=0; i+k<=n; i++) {
            //Clear and fill priority queue for current window
            pq.clear();
            for(var e : freq.entrySet()) {
                pq.add(new int[]{e.getKey(),e.getValue()});
            }

            //sum me top x elements ka contribution add karte hain as num * freq.

            int sum=0,cnt=0;
            while(!pq.isEmpty()&&cnt<x) {
                int[] t=pq.poll();
                sum+=t[0]*t[1];
                cnt++;
            }
            ans[i]=sum;

            //Agar ye last window hai to loop break karo
            if(i+k==n)break;
            int left=nums[i],right=nums[i+k];
            freq.put(left,freq.get(left)-1);
            if(freq.get(left)==0)freq.remove(left);
            freq.put(right,freq.getOrDefault(right,0)+1);
        }
        return ans;
    }
}
