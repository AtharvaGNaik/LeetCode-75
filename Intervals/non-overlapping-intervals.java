class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      // Sort by ending time
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
      int prev = 0, count  = 1;
      // if end is same, sort by start, bigger start in front
      for(int i = 0; i < intervals.length; i ++) {
          if(intervals[i][0] >= intervals[prev][1]) {
              prev = i;
              count ++;
          }
      }
      return intervals.length - count;
    }
}
// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 
// Example 1:
// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

// Example 2:
// Input: intervals = [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

// Example 3:
// Input: intervals = [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
