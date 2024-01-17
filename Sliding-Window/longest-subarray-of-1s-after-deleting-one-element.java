class Solution {
    public int longestSubarray(int[] nums) {
        int maxlen = 0, strt = 0, end = 0, zero = 0;
        for (; end < nums.length; end++) {
            if (nums[end] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[strt] == 0) {
                    zero--;
                } 
              strt++;
            }
            maxlen = Math.max(maxlen, (end - strt));
        }
        return maxlen;
    }
} 

So FIRST WE CHECK IF THE ELEMENT COMING INSIDE THE WINDOW IS A 0 AND IF YES WE SIMPLY INCREASE THE  ZERO COUNT AND THWN WE HAVE AN INNER WHILE LOOP TO SHIFT THE 
WINDOW AHEAD IF THE COUNT OF ZERO IS > THAN ONE (AS THE PERMISSABLE NUMBER OF ZEROES IS 1) IF THE ELEMENT LEAVING THE WINDOW IS ZERO  THEN WE JUST DECREMENT THE ZERO
COUNT AND UNTIL THE WHILE CONDITION IS FALSE. 

    THEN .....

AT LINE 14 WE DIDN'T ADD ONE TO THE LENGTH AS WE HAVE  ALLOWED A SINGLE ZERO TO BE INSIDE THE WINDOW AND WE ARE SUPPOSED TO SHOW THELONGEST SUBARRAY OF 1"s" AFTER
REMOVING THE ZERO S0... COMING BACK TO LINE 14, WE ASSUME THAT THE PERMISSIBLE ZERO WAS REMOVED AND THE MAX LENGTH IS CALCULATED UPON THIS ASSUMPTION.

    

// Given a binary array nums, you should delete one element from it.

// Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

 

// Example 1:

// Input: nums = [1,1,0,1]
// Output: 3
// Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
// Example 2:

// Input: nums = [0,1,1,1,0,1,1,0,1]
// Output: 5
// Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
// Example 3:

// Input: nums = [1,1,1]
// Output: 2
// Explanation: You must delete one element.
 
