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

// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

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
 
