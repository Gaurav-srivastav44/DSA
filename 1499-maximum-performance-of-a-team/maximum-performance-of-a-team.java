class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1000000007;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = efficiency[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b) -> b[0]-a[0]);

        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        long sum=0;
        long ans =0;

        for(int[] i : arr){
            sum += i[1];
            pq.add(i[1]);

            if(pq.size() > k){
                sum -= pq.poll();
            }

            ans = Math.max(ans, sum * i[0]);
        }
        return (int)(ans%mod);
    }
}