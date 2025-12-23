class Solution {
    public String pushDominoes(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = -1; 
        char prev = 'L';

        for (int i = 0; i <= n; i++) {
            char cur = i == n ? 'R' : arr[i];
            if (cur == '.') continue;

            if (cur == prev) {
                for (int k = left + 1; k < i; k++)
                    arr[k] = cur;
            }
            else if(prev=='R' && cur=='L') {
                int l=left+1, r=i-1;
                while (l < r) {
                    arr[l++] = 'R';
                    arr[r--] = 'L';
                }
            }
            left = i;
            prev = cur;
        }

        return new String(arr);
    }
}
