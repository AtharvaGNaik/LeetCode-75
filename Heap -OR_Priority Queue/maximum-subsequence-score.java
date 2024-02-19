class Solution {
    record Pair(int a, int b) {}
    public long maxScore(int[] a, int[] b, int k) {
        int n = a.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) pairs[i] = new Pair(a[i], b[i]);
        Arrays.sort(pairs, (x, y) -> y.b - x.b);
        Queue<Integer> q = new PriorityQueue<>(k+1);
        long res = 0, sum = 0;
        for (var p : pairs) {
            q.add(p.a);
            sum += p.a;
            if (q.size() > k) sum -= q.poll();
            if (q.size() == k) res = Math.max(res, sum * p.b);
        }
        return res;
    }
}

Intuition
How should we approach this problem?
We want to maximize sum * min of subsequence pair
At most, there can be n-k+1 min values no matter how are you going to chose the sub-sequence, right? This is key!!!!
For each of the n-k+1 min values, we want the max sum (when there's duplicates)

Approach
We create pair of both array into a new array (you could also create an sorted index array, same idea)
Sort the new pair array by second array value in descending order
use an priorityqueue/minHeap of exact size k to maintain top k of all values you met so far from array for max sum of each min value





// You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.
// For chosen indices i0, i1, ..., ik - 1, your score is defined as:
// The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
// It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
// Return the maximum possible score.
// A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

// Example 1:
// Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
// Output: 12
// Explanation: 
// The four possible subsequence scores are:
// - We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
// - We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6. 
// - We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12. 
// - We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
// Therefore, we return the max score, which is 12.

// Example 2:
// Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
// Output: 30
// Explanation: 
// Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
