class Solution {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount(a & ~c) +  Integer.bitCount(~(a | b) & c) + Integer.bitCount(b & ~c);
    }
}

Example 1:
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)

Example 2:

Input: a = 4, b = 2, c = 7
Output: 1

Example 3:

Input: a = 1, b = 2, c = 3
Output: 0
