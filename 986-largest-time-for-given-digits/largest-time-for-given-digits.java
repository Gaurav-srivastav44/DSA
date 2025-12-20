class Solution {

    public String largestTimeFromDigits(int[] arr) {

        String[] list = new String[24];
        int[] idx = {0};

        permute(arr, 0, list, idx);   // generate permutations

        int max = -1;
        String ans = "";

        for (int i = 0; i < idx[0]; i++) {
            if (isValid(list[i])) {

                if (ans.equals("")) ans = list[i];      // first valid time becomes answer
        
                else {
                    String s = list[i];

                    int h1 = s.charAt(0)-'0', h2 = s.charAt(1)-'0';
                    int m1 = s.charAt(2)-'0', m2 = s.charAt(3)-'0';

                    int ah1 = ans.charAt(0)-'0', ah2 = ans.charAt(1)-'0';
                    int am1 = ans.charAt(2)-'0', am2 = ans.charAt(3)-'0';

                    // compare hour first then minutes (index-based)
                    if (h1>ah1 ||
                       (h1==ah1 && h2>ah2) || 
                       (h1==ah1 && h2==ah2 && m1>am1) ||
                       (h1==ah1 && h2==ah2 && m1==am1 && m2>am2))
                    {                    
                        ans = s;
                    }
                }
            }
        }

        if (ans.equals("")) return "";
        return ans.substring(0,2) + ":" + ans.substring(2);
    }


    void permute(int[] a, int i, String[] list, int[] idx) {

        if (i == 4) {
            list[idx[0]++] = "" + a[0] + a[1] + a[2] + a[3];
            return;
        }

        for (int j = i; j < 4; j++) {
            swap(a, i, j);
            permute(a, i + 1, list, idx);
            swap(a, i, j);  
        }
    }


    // index-based validity check
    boolean isValid(String s) {
        int h1 = s.charAt(0) - '0';
        int h2 = s.charAt(1) - '0';
        int m1 = s.charAt(2) - '0';
        int m2 = s.charAt(3) - '0';

        if (h1 > 2) return false;
        if (h1 == 2 && h2 > 3) return false;
        if (m1 > 5) return false;
        return true; 
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
