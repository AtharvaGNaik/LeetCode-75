class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder SB_result = new StringBuilder();

        int word1Length = word1.length();
        int word2Length = word2.length();

        int j = 0;
        for (int i = 0; i < word1Length; i++) {
            SB_result.append(word1.charAt(i));

            if (j < word2Length) {
                SB_result.append(word2.charAt(j));
                j++;
            }
        }

        while (j < word2Length) {
            SB_result.append(word2.charAt(j));
            j++;
        }

        return SB_result.toString();
    }
}
