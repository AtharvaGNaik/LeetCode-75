class Solution {
    public int findPeakElement(int[] nums) {
        int pk = 0;
        if(nums.length==2){
            if(nums[0]>nums[1]) return 0;
            else return 1;
        }
        for(int i=1; i<nums.length-1; i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) pk=i;
            else if(nums[i]<nums[i+1]) pk = i+1;
        }
        return pk;
    }
}

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.

// Example 2:

// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
