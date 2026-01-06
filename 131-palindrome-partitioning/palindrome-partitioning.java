class Solution {
    public List<List<String>> partition(String s) {
        return solve(0, s);
    }

    public List<List<String>> solve(int i, String s) {
        List<List<String>> res = new ArrayList<>();

        if (i == s.length()) {
            res.add(new ArrayList<>());
            return res;
        }

        for (int end = i; end < s.length(); end++) {
            if (isPalindrome(s, i, end)) {
                String part = s.substring(i, end+1);

                List<List<String>> sub = solve(end+1, s);
                for (List<String> l : sub) {
                    List<String> curr = new ArrayList<>();
                    curr.add(part);
                    curr.addAll(l);
                    res.add(curr);
                }
            }
        }
        return res;
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
