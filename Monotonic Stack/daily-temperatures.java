
https://leetcode.com/problems/daily-temperatures/solutions/4651723/easy-stack-friendly-explained

class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] results = new int[temps.length];
        Stack<Integer> stack = new Stack<>();
        /// UPVOTE !
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }
}




Intuition
The goal is to find the number of days one has to wait until a warmer day for each given day's temperature. This can be efficiently solved using a stack.

Approach
Initialize an array results to store the number of days until a warmer day for each day's temperature.
Initialize an empty stack to keep track of indices.
Iterate through each temperature in the array.
While the stack is not empty and the current temperature is greater than the temperature at the index on the top of the stack:
Update the result for the index at the top of the stack with the difference between the current index and the index on the top of the stack.
Pop the index from the stack.
Push the current index onto the stack.
After the iteration, the results array contains the number of days until a warmer day for each given day.

// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

// Example 1:
// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]
  
// Example 2:
// Input: temperatures = [30,40,50,60]
// Output: [1,1,1,0]
  
// Example 3:
// Input: temperatures = [30,60,90]
// Output: [1,1,0]
