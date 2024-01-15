class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int maxcount = 0;
        int currentCount = 0; // Variable to store the count of vowels in the current substring
        String vow = "aeiouAEIOU";

        // Initialize the count of vowels in the first substring of length k
        for (int j = 0; j < k; j++) {
            if (vow.indexOf(s.charAt(j)) != -1) {
                currentCount++;
            }
        }

        // Update maxcount with the count of vowels in the initial substring
        maxcount = currentCount;

        // Iterate through the remaining substrings using a sliding window
        while (i + k < s.length()) {
            // Check if the character leaving the window is a vowel and decrement the count if necessary
            if (vow.indexOf(s.charAt(i)) != -1) {
                currentCount--;
            }

            // Check if the character entering the window is a vowel and increment the count if necessary
            if (vow.indexOf(s.charAt(i + k)) != -1) {
                currentCount++;
            }

            // Update maxcount with the maximum vowel count encountered so far
            maxcount = Math.max(maxcount, currentCount);

            i++;
        }

        return maxcount;
    }
}
// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

// Example 1:

// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.
// Example 2:

// Input: s = "aeiou", k = 2
// Output: 2
// Explanation: Any substring of length 2 contains 2 vowels.
// Example 3:

// Input: s = "leetcode", k = 3
// Output: 2
// Explanation: "lee", "eet" and "ode" contain 2 vowels.
 
