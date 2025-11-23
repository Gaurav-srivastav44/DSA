class Solution {
    public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> mod1 = new ArrayList<>();
        ArrayList<Integer> mod2 = new ArrayList<>();

        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (i % 3 == 1) mod1.add(i);
            else if (i % 3 == 2) mod2.add(i);
        }

        if (sum % 3 == 0) return sum;

        Collections.sort(mod1);
        Collections.sort(mod2);

        int remove = Integer.MAX_VALUE;

        if (sum % 3 == 1) {
            if (mod1.size() >= 1) remove = Math.min(remove, mod1.get(0));
            if (mod2.size() >= 2) remove = Math.min(remove, mod2.get(0) + mod2.get(1));
        } else {
            if (mod2.size() >= 1) remove = Math.min(remove, mod2.get(0));
            if (mod1.size() >= 2) remove = Math.min(remove, mod1.get(0) + mod1.get(1));
        }

        return sum - remove;
    }
}
