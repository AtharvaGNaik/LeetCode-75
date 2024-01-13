class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0, j = nums.length - 1; i < j;) {
            int sum = nums[i] + nums[j];

            if (sum == k) {
                i++;
                j--;
                count++;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
 
// EXPLANATION 

//   Sorting the Array
// java
// Copy code
// Arrays.sort(nums);
// The Arrays.sort(nums) method is used to sort the input array nums in ascending order.
// Sorting is a crucial step for the two-pointer approach, which involves iterating through the array with two pointers, one starting from the beginning (i) and the other from the end (j).
// Initializing Pointers and Count
// java
// Copy code
// int count = 0;
// for (int i = 0, j = nums.length - 1; i < j;) {
//     // ...
// }
// count: This variable is initialized to zero and will be used to keep track of the number of pairs found.
// i and j: These are the two pointers used in the two-pointer approach.
// i starts from the beginning of the sorted array.
// j starts from the end of the sorted array.
// The loop continues as long as i is less than j, ensuring that the pointers do not overlap.
// Two-Pointer Approach
// java
// Copy code
// int sum = nums[i] + nums[j];
// if (sum == k) {
//     i++;
//     j--;
//     count++;
// } else if (sum < k) {
//     i++;
// } else {
//     j--;
// }
// The loop iterates as long as i is less than j, ensuring that the pointers do not overlap.
// sum: Calculates the sum of elements at positions i and j.
// Three possible cases based on the value of sum compared to the target value k:
// Case: sum == k
// Increment both i and j to move to the next pair.
// Increment count to record the found pair.
// Case: sum < k
// Increment i to move to the next pair, as the sum is currently less than the target.
// Case: sum > k
// Decrement j to move to the next pair, as the sum is currently greater than the target.
// Final Result

 // Example 1:

// Input: nums = [1,2,3,4], k = 5
// Output: 2
// Explanation: Starting with nums = [1,2,3,4]:
// - Remove numbers 1 and 4, then nums = [2,3]
// - Remove numbers 2 and 3, then nums = []
// There are no more pairs that sum up to 5, hence a total of 2 operations.
// Example 2:

// Input: nums = [3,1,3,4,3], k = 6
// Output: 1
// Explanation: Starting with nums = [3,1,3,4,3]:
// - Remove the first two 3's, then nums = [1,4,3]
// There are no more pairs that sum up to 6, hence a total of 1 operation.
