
// Intuition
// We are going to use the Binary Search algorithm to optimize the approach.
// The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.
// Now, we are not given any sorted array on which we can apply binary search. But, if we observe closely, we can notice that our answer space i.e. [1, max(a[])] is sorted. So, we will apply binary search on the answer space.

// Algorithm
// First, we will find the maximum element in the given array i.e. max(a[]).
// Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to max(a[]).
// Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
// mid = (low+high) // 2 ( ‘//’ refers to integer division)
// Eliminate the halves based on the time required if Koko eats ‘mid’ bananas/hr:
// We will first calculate the total time(required to consume all the bananas in the array) i.e. totalH using the function calculateTotalHours(a[], mid):
// If totalH <= h: On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible answers. But we want the minimum number. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
// Otherwise, the value mid is smaller than the number we want(as the totalH > h). This means the numbers greater than ‘mid’ should be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
// Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
// The steps from 2-4 will be inside a loop and the loop will continue until low crosses high.




class Solution {
    public static int findMax(int[] piles ){
        int n = piles.length;
        int max = piles[0];

        for(int i =0 ; i < n ;i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

        return max;
    }

    public static int findTotalHours(int[] piles , int hours){
        int n = piles.length;
        int totalHrs = 0;
        for(int i =0 ;i <  n; i++){
            totalHrs += Math.ceil((double) piles[i] /(double) hours);       // type casting 
        }

        return totalHrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        while(low <= high){
            int mid = (low + high)/2;
            int totalHours = findTotalHours(piles , mid);
            
            if(totalHours <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    } 
}


// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.
  
// Example 1:
// Input: piles = [3,6,7,11], h = 8
// Output: 4
  
// Example 2:
// Input: piles = [30,11,23,4,20], h = 5
// Output: 30
  
// Example 3:
// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
