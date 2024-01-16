class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;

        for (int strt = 0, end = 0; end < nums.length && strt < nums.length; end++){
            if (nums[end] == 0){
                k--;
            }
            while (k < 0){
                if (nums[strt++] == 0){k++;}
            }
            ans = Math.max(ans, (end - strt + 1));
        }return ans; }
}


// SO, BASICALLY WE TAKE AN ARRAY AND WE TRAVERSE IT BY A SLIDING WINDOW WHILE WE ENCOUNTER A ZERO FROM TEH END OF THE WINDOW , AS WE HAVE TO FLIP THE K NUMBER OF 
// ZEROES TO GET THE LONGEST SUBARRAY OF ONE'S, WE DECEREMENT THE K-- AS WE FOUND A ZERO AND FLIPPED IT THEN.....WHEN THE ZEROES ARE MORE THAN K : K WILL BECOME NEGATIVE 
// HENCE WE TRAVERSE (MOVE) THE WINDOW FROM START IE LEFT IF {{{ [[START++]] == 0 }}} K++ TO DENAGATE THE NUMBER OF K'S SO...THEN OUT OF THE INNER WHILE LOOP WE CALCULATE THE 
// LENGTH OF THE SUBARRAY BY {{{{ { [[ Math.max(ANS,(END - START + 1) }} }}}} SO IN GENERAL I DONT UNDERSTAND;

// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0'
// int[] nums = {0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1};
// int k = 2;
// Iteration 1:

// end points to 0 (nums[0]). k is decremented to 1. ans remains unchanged.
// Iteration 2:

// end points to 0 (nums[1]). k is decremented to 0. ans remains unchanged.
// Iteration 3:

// end points to 1 (nums[2]). k and ans remain unchanged.
// Iteration 4:

// end points to 1 (nums[3]). k and ans remain unchanged.
// Iteration 5:

// end points to 1 (nums[4]). k and ans remain unchanged.
// Iteration 6:

// end points to 0 (nums[5]). k is decremented to -1.
// Enter the while loop. strt is incremented until k becomes non-negative.
// strt is now at index 2 (first 0 in the current window). k is incremented to 0.
// Update ans to (end - strt + 1), which is 5 - 2 + 1 = 4.
// Iteration 7:

// end points to 1 (nums[6]). k and ans remain unchanged.
// Iteration 8:

// end points to 1 (nums[7]). k and ans remain unchanged.
// Iteration 9:

// end points to 0 (nums[8]). k is decremented to -1.
// Enter the while loop. strt is incremented until k becomes non-negative.
// strt is now at index 6 (second 0 in the current window). k is incremented to 0.
// Update ans to (end - strt + 1), which is 9 - 6 + 1 = 4.
// Iteration 10:

// end points to 1 (nums[9]). k and ans remain unchanged.
// Iteration 11:

// end points to 1 (nums[10]). k and ans remain unchanged.
// Final Result:
// The maximum length of consecutive 1's with at most 2 flips is 4, and the iterations demonstrate encountering zeros and adjusting the window accordingly.


 

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 
