class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[k];
        for (int i=0; i<k; i++){
            arr[i] = i+1;
        }

        while (true) {
            List<Integer> temp = new ArrayList<>();
            for (int x : arr){
                temp.add(x);
            }
            ans.add(temp);

            int i=k-1;
            while(i>=0 && arr[i]==n-k+i+1){
                i--;
            }
            if (i<0){
                break;
            }
            arr[i]++;
            for (int j=i+1; j<k; j++){
                arr[j] = arr[j-1]+1;
            }
        }

        return ans;
    }
}
