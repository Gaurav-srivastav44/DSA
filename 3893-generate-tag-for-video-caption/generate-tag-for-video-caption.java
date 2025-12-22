class Solution {
    public String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");
        StringBuilder sb = new StringBuilder("#");

        if (words.length == 0) return "#";

        for (int i=0; i<words.length; i++) {
            String w = words[i].toLowerCase();

            if (i==0) {
                sb.append(w);
            }
            else {
                sb.append(Character.toUpperCase(w.charAt(0)));
                if (w.length() > 1)
                    sb.append(w.substring(1));
            }

            if (sb.length() >= 100) break;
        }

        if (sb.length() > 100) {
            return sb.substring(0, 100);
        }
        else {
            return sb.toString();
        }

    }
}
