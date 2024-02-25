

https://leetcode.com/problems/letter-combinations-of-a-phone-number/solutions/4762018/solution-100-beats-generate-all-letter-combinations-of-a-phone-number-with-backtracking



class Solution {
    public void solve(int index, String digits, String[] mapping, List<String> result, StringBuilder output) {
        // Base case
        if (index >= digits.length()) {
            result.add(output.toString());
            return;
        }

        // Get the current digit
        int digit = digits.charAt(index) - '0';
        String value = mapping[digit];

        // Iterate over the characters corresponding to the current digit
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            // Include the character
            output.append(ch);
            // Recursive call for the next index
            solve(index + 1, digits, mapping, result, output);
            // Backtrack
            output.deleteCharAt(output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        if (digits.length() == 0)
            return result;
        int index = 0;
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(index, digits, mapping, result, output);

        return result;
    }
}


Intuition
To generate all possible letter combinations from a given string of digits, we can utilize backtracking. We start with an empty output string and recursively explore all possible combinations by appending characters corresponding to each digit in the input string.

Approach
Define a function solve that takes the current index, the input string of digits, the mapping of digits to letters, the result vector to store combinations, and the current output string.
In the solve function:
Base case: If the index exceeds the length of the input digits string, add the current output string to the result vector and return.
Get the current digit and corresponding letters from the mapping.
Iterate through each letter corresponding to the current digit:
Append the letter to the output string.
Recur with the next index.
Backtrack by removing the last character from the output string.
In the letterCombinations function:
Initialize an empty result vector and an empty output string.
If the input string is empty, return the result vector.
Define a mapping of digits to letters.
Call the solve function with initial parameters.
Return the result vector.

Complexity
Time complexity: The time complexity depends on the number of possible combinations generated. In the worst case, each digit corresponds to a maximum of 4 letters, so the time complexity is O(4^N), where N is the length of the input string of digits.

Space complexity: The space complexity is also O(4^N) as we store all possible combinations in the result vector. Additionally, the recursive stack space for backtracking contributes to the space complexity. However, since the maximum depth of recursion is limited by the length of the input string, the overall space complexity is still O(4^N).

Dry Run
Let's dry run the code with the input digits = "23" and create a binary tree to visualize the recursive process.

Initial Setup:
digits = "23"
mapping[2] = "abc"
mapping[3] = "def"
Call letterCombinations("23"):
index = 0, output = ""
Start with digit 2, which corresponds to letters "abc".
Call solve(0, "23", mapping, result, "").
index = 0, digit = 2, value = "abc".
Iterate over letters "abc":
Take letter 'a', append to output.
Recur with index = 1.
Start with digit 3, which corresponds to letters "def".
Call solve(1, "23", mapping, result, "a").
index = 1, digit = 3, value = "def".
Iterate over letters "def":
Take letter 'd', append to output.
Recur with index = 2.
Since index exceeds length, add "ad" to result.
Backtrack, remove 'd' from output.
Take letter 'e', append to output.
Recur with index = 2.
Since index exceeds length, add "ae" to result.
Backtrack, remove 'e' from output.
Take letter 'f', append to output.
Recur with index = 2.
Since index exceeds length, add "af" to result.
Backtrack, remove 'f' from output.
Backtrack, remove 'a' from output.
Backtrack, remove 'a' from output.
Take letter 'b', append to output.
Recur with index = 1 (similar process).
Backtrack, remove 'b' from output.
Take letter 'c', append to output.
Recur with index = 1 (similar process).
Backtrack, remove 'c' from output.
Result:
The result vector will contain ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Binary Tree Visualization:
                         ""
              /          |         \
             a           b          c
           / | \       / | \      / | \
          ad ae af    bd be bf   cd ce cf
This binary tree illustrates the recursive exploration of all possible combinations. Each level represents a digit, and each branch represents a letter choice. The leaf nodes represent the final combinations added to the result.




// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:
// Input: digits = ""
// Output: []
// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"]
