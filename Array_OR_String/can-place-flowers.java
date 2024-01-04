class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, i = 0,prv,nxt;
        
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0) {
                 prv = (i == 0) ? 0 : flowerbed[i - 1];
                 nxt = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];

                if (prv == 0 && nxt == 0) {
                    flowerbed[i] = 1;
                    count++;
                    i += 2;  // Move to the next potential planting position
                } else {
                    i++;  // Move to the next plot
                }
            } else {
                // If the current plot is not empty, skip the next plot
                i += 2;  // Move to the next potential planting position
            }
        }

        return count >= n;
    }
}





You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
