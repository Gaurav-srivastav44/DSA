import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);
        for (int[] e : connections) dsu.union(e[0], e[1]);
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int p = dsu.find(i);
            map.computeIfAbsent(p, k -> new TreeSet<>()).add(i);
        }
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int t = q[0], x = q[1], p = dsu.find(x);
            TreeSet<Integer> set = map.get(p);
            if (t == 1) {
                if (set.contains(x)) res.add(x);
                else res.add(set.isEmpty() ? -1 : set.first());
            } else if (t == 2) {
                if (set != null) set.remove(x);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }
        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (r[pa] < r[pb]) p[pa] = pb;
            else if (r[pb] < r[pa]) p[pb] = pa;
            else {
                p[pb] = pa;
                r[pa]++;
            }
        }
    }
}
