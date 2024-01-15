class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0,i, maxsum;
        for (i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxsum = sum;
        while (i < nums.length) {
            
            sum -= nums[i - k];
            //REMOVING OUT OF THE WINDOW
            
            sum += nums[i];
            
            //ADDING TO THE WINDOW

            maxsum = Math.max(maxsum, sum);

            //UPDATING THE WHOLE WINDOW AND THE MAXSUM TO GET TO THE NEXT WINDOW
            i++;
        }
        return (double) maxsum / k;
    }
}


// You are given an integer array nums consisting of n elements, and an integer k.

// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 

// Example 1:

// Input: nums = [1,12,-5,-6,50,3], k = 4
// Output: 12.75000
// Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
// Example 2:

// Input: nums = [5], k = 1
// Output: 5.00000




//     EXPLAINATION



// Initialization:

// Initialize a variable sum to store the sum of the first k elements.
// Iterate through the first k elements of the array and add each element to the sum.
// java
// Copy code
// int sum = 0;
// for (int i = 0; i < k; i++) {
//     sum += nums[i];
// }
// At this point, sum contains the sum of the first k elements.

// Sliding Window:

// Initialize another variable maxSum with the initial sum. This variable will keep track of the maximum sum encountered during the sliding window process.
// Use a loop starting from index k and iterate through the rest of the array.
// java
// Copy code
// int maxSum = sum;
// for (int i = k; i < nums.length; i++) {
//     // Update the sum by adding the current element and subtracting the element k positions back
//     sum += nums[i] - nums[i - k];

    // Update maxSum if the current sum is greater
//     maxSum = Math.max(maxSum, sum);
// }
// In each iteration of the loop, the sliding window advances by one element. The sum is updated by subtracting the leftmost element (at index i - k) and adding the current element (at index i). This represents moving the window one step to the right. The maxSum is updated whenever a new maximum sum is encountered.

// Result:

// The final result is the maximum average, which is calculated by dividing maxSum by k and returning the result as a double.
// java
// Copy code
// return (double) maxSum / k;
// The sliding window approach allows you to efficiently calculate the sum of consecutive subarrays without the need to recompute the entire sum for each subarray. It significantly improves the time complexity compared to a brute-force approach.
