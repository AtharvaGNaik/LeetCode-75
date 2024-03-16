class Solution {
   // Finds the minimum number of arrows needed to burst all balloons
   public int findMinArrowShots(int[][] points) {
        // Sort the balloons by the end position of the arrow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        
        // Initialize the number of arrows needed to 1
        int result = 1;
        // Set the index of the previously burst balloon to 0
        int previous = 0;
        
        // Iterate through all balloons
        for(int current = 1; current < points.length; current++){
            // If the start position of the current balloon is after the end position of the arrow that burst the previous balloon,
            // then a new arrow is needed to burst the current balloon
            if(points[current][0] > points[previous][1]){
                result++;
                // Update the index of the previously burst balloon
                previous = current;
            }
        }
        return result;            
    }
}



Approach
The approach used here is to sort the intervals by their end point (the second element of each interval), and then iterate through the sorted list. At each iteration, we compare the start point of the current interval with the end point of the previous interval. If the start point of the current interval is after the end point of the previous interval, it means that the current interval does not overlap with the previous one, and therefore we need an additional arrow to burst the current interval. If the start point of the current interval is before or at the same point as the end point of the previous interval, it means that the current interval overlaps with the previous one, and we can burst both intervals with only one arrow.This solution works because if we sort the intervals by their end point, it will always be optimal to use the minimum number of arrows to burst the intervals that end first. This is because, if we have two intervals A and B such that A ends before B and we use one arrow to burst A, it means that we cannot use that same arrow to burst B, and therefore we must use an additional arrow for B. Therefore, it is always optimal to use the minimum number of arrows to burst the intervals that end first.

  There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

// Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

// Example 1:
// Input: points = [[10,16],[2,8],[1,6],[7,12]]
// Output: 2
// Explanation: The balloons can be burst by 2 arrows:
// - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
// - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

// Example 2:
// Input: points = [[1,2],[3,4],[5,6],[7,8]]
// Output: 4
// Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.

// Example 3:
// Input: points = [[1,2],[2,3],[3,4],[4,5]]
// Output: 2
// Explanation: The balloons can be burst by 2 arrows:
// - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
// - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
