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

// Example 1:

// Input: word1 = "abc", word2 = "pqr"
// Output: "apbqcr"
// Explanation: The merged string will be merged as so:
// word1:  a   b   c
// word2:    p   q   r
// merged: a p b q c r

// Example 2:

// Input: word1 = "ab", word2 = "pqrs"
// Output: "apbqrs"
// Explanation: Notice that as word2 is longer, "rs" is appended to the end.
// word1:  a   b 
// word2:    p   q   r   s
// merged: a p b q   r   s

// Example 3:

// Input: word1 = "abcd", word2 = "pq"
// Output: "apbqcd"
// Explanation: Notice that as word1 is longer, "cd" is appended to the end.
// word1:  a   b   c   d
// word2:    p   q 
// merged: a p b q c   d
