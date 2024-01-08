class Solution {
    public int[] productExceptSelf(int[] nums) {
              int n = nums.length;

        // Initialize left and right product arrays
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] result = new int[n];

        // Compute left products
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            leftProducts[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Compute right products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            rightProducts[i] = rightProduct;
            rightProduct *= nums[i];
        }

        // Compute the final result
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
        
    }
}

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]



//     Example: nums = [1, 2, 3, 4]

// Left Products:

// Initialize leftProducts array: [1, 1, 1, 1]
// Iterate from left to right:
// For index 0: leftProducts[0] = 1
// For index 1: leftProducts[1] = leftProducts[0] * nums[0] = 1 * 1 = 1
// For index 2: leftProducts[2] = leftProducts[1] * nums[1] = 1 * 2 = 2
// For index 3: leftProducts[3] = leftProducts[2] * nums[2] = 2 * 3 = 6
// Final leftProducts array: [1, 1, 2, 6]

// Right Products:

// Initialize rightProducts array: [1, 1, 1, 1]
// Iterate from right to left:
// For index 3: rightProducts[3] = 1
// For index 2: rightProducts[2] = rightProducts[3] * nums[3] = 1 * 4 = 4
// For index 1: rightProducts[1] = rightProducts[2] * nums[2] = 4 * 3 = 12
// For index 0: rightProducts[0] = rightProducts[1] * nums[1] = 12 * 2 = 24
// Final rightProducts array: [24, 12, 4, 1]

// Final Result:

// Multiply corresponding elements from leftProducts and rightProducts arrays:
// For index 0: result[0] = leftProducts[0] * rightProducts[0] = 1 * 24 = 24
// For index 1: result[1] = leftProducts[1] * rightProducts[1] = 1 * 12 = 12
// For index 2: result[2] = leftProducts[2] * rightProducts[2] = 2 * 4 = 8
// For index 3: result[3] = leftProducts[3] * rightProducts[3] = 6 * 1 = 6
// Final result array: [24, 12, 8, 6]

// These calculations ensure that the product of all elements except the current one is correctly computed for each index, satisfying the requirements of the problem.
