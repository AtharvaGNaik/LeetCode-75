https://leetcode.com/problems/house-robber/solutions/4600148/beats-100-c-java-python-js-explained-with-video-dynamic-programming-space-optimized


class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int norob = 0;
        for (int i = 0; i < nums.length; i ++) {
            int newRob = norob + nums[i];
            int newNoRob = Math.max(norob, rob);
            rob = newRob;
            norob = newNoRob;
        }
        return Math.max(rob, norob);
    }
}
YouTube Video Explanation:


🔥 Please like, share, and subscribe to support our channel's mission of making complex concepts easy to understand.

Subscribe Link: https://www.youtube.com/@leetlogics/?sub_confirmation=1

Subscribe Goal: 1600 Subscribers
Current Subscribers: 1513

Intuition
The problem can be solved by dynamic programming, considering the two scenarios at each house: whether to rob it or not. The goal is to maximize the total amount of money robbed without alerting the police.

Approach
Use two variables, rob and norob, to keep track of the maximum amount of money robbed with or without robbing the current house.
Iterate through each house, and at each step, calculate the maximum amount of money if the current house is robbed (newRob) and if it is not robbed (newNoRob).
Update rob and norob for the next iteration.
The final result is the maximum amount between the two scenarios: robbing the last house or not robbing it.
Complexity
Time Complexity: O(N), where N is the number of houses.
Space Complexity: O(1), as we use constant space for variables rob and norob.
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 2:
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
