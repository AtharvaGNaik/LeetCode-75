class Solution {
    public String removeStars(String s) {
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                c.deleteCharAt(c.length() - 1);
            } else {
                c.append(s.charAt(i));
            }
        }
        return c.toString();
    }
}

// This code defines a function removeStars that takes a string s as input and returns a modified version of the input string with all asterisks (*) removed along with the preceding character.

// Here is a step-by-step explanation of the code:

// Initialize an empty list ans that will be used to build the modified string.
// Loop through each character i in the input string s.
// If the current character i is an asterisk, remove the last element from the ans list.
// If the current character i is not an asterisk, add it to the end of the ans list.
// Join the elements in the ans list into a string and return the result.
// For example, if the input string is abc*d*ef*g*, the function would first create an empty list ans = []. Then, it would loop through each character in the string as follows:

// i = 'a': append 'a' to ans (ans = ['a'])
// i = 'b': append 'b' to ans (ans = ['a', 'b'])
// i = 'c': append 'c' to ans (ans = ['a', 'b', 'c'])
// i = '*': remove the last element from ans (ans = ['a', 'b'])
// i = 'd': append 'd' to ans (ans = ['a', 'b', 'd'])
// i = '*': remove the last element from ans (ans = ['a','b'])
// i = 'e': append 'e' to ans (ans = ['a','b', 'e'])
// i = 'f': append 'f' to ans (ans = ['a','b', 'e', 'f'])
// i = '*': remove the last element from ans (ans = ['a','b', 'e'])
// i = 'g': append 'g' to ans (ans = ['a','b', 'e', 'g'])
// i== '*': remove the last element from ans (ans = ['a','b', 'e'])
// Finally, the function would join the elements in ans into a string ('abe') and return the result.



//   You are given a string s, which contains stars *.

// In one operation, you can:

// Choose a star in s.
// Remove the closest non-star character to its left, as well as remove the star itself.
// Return the string after all stars have been removed.

// Note:

// The input will be generated such that the operation is always possible.
// It can be shown that the resulting string will always be unique.
 

// Example 1:

// Input: s = "leet**cod*e"
// Output: "lecoe"
// Explanation: Performing the removals from left to right:
// - The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
// - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
// - The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
// There are no more stars, so we return "lecoe".
// Example 2:

// Input: s = "erase*****"
// Output: ""
// Explanation: The entire string is removed, so we return an empty string.
