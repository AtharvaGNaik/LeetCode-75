class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder SB_result = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                SB_result.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                SB_result.append(word2.charAt(j));
                j++;
            }
        }

        return SB_result.toString();
    }
}
