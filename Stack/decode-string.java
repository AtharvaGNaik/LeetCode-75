class Solution {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> st1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            } else if (c == '[') {
                st.push(n);
                n = 0;
                st1.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int k = st.pop();
                StringBuilder temp = sb;
                sb = st1.pop();
                while (k-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

// Intuition: The intuition behind this solution is to use two stacks—one to keep track of the number of times a string needs to be repeated (st), and another to store the intermediate results (st1). By iterating through the input string, we build the decoded string by repeating and concatenating substrings based on the count provided in the input.

// Approach:

// Initialize a stack for counts (st) and another stack for intermediate results (st1).
// Iterate through the characters of the input string.
// If a digit is encountered, update the count accordingly.
// If an opening bracket '[' is encountered, push the current count (n) onto the count stack and reset the count to 0. Push the current result (sb) onto the result stack and reset the result.
// If a closing bracket ']' is encountered, pop the count (k) from the count stack and the intermediate result (temp) from the result stack. Repeat the current result (sb) by appending temp to it k times.
// If any other character is encountered, append it to the current result (sb).
// After processing all characters, the final result is stored in the last sb value.
// Complexity:

// Time complexity: O(n), where n is the length of the input string. Each character is processed once.
// Space complexity: O(n), where n is the length of the input string. The space required is proportional to the size of the intermediate result stack (st1)

// Given an encoded string, return its decoded string.
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
// The test cases are generated so that the length of the output will never exceed 105.

// Example 1:
// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
  
// Example 2:
// Input: s = "3[a2[c]]"
// Output: "accaccacc"
  
// Example 3:
// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"



  
