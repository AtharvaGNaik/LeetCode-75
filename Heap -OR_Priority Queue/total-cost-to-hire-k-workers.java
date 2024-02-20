
https://leetcode.com/problems/total-cost-to-hire-k-workers/solutions/4436680/java-solution-with-2-minheaps-runtime-16ms-beats-100-00-of-users


class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

       long cost = 0;

        int startPtr = candidates - 1;
        int endPtr = costs.length - candidates;

        if (startPtr >= endPtr) {
            endPtr = startPtr + 1;
        }

        int[] startCandidates = Arrays.copyOfRange(costs, 0, startPtr + 1);
        int[] endCandidates = Arrays.copyOfRange(costs, endPtr, costs.length);


        int startLimit = startCandidates.length;
        int endLimit = endCandidates.length;

        buildMinHeap(startCandidates);
        buildMinHeap(endCandidates);
    
        while (k > 0) {
            int startMin = startCandidates[0];
            int endMin;

            if (endCandidates.length > 0) {
                 endMin = endCandidates[0];
            } else {
                 endMin = 10000000;
            }

            if (startLimit == 0) startMin = 10000000;
            if (endLimit == 0) endMin = 10000000;

            if (startMin <= endMin) {
                cost = cost + startMin;
                if (startPtr < endPtr - 1) {
                    startCandidates[0] = costs[++startPtr];
                    minHeapify(0, startCandidates, candidates);
                } else {
                    swap(startCandidates, 0, startLimit - 1) ;
                    minHeapify(0, startCandidates, --startLimit);
                }
            } else {
                cost = cost + endMin;

                if(endPtr > startPtr + 1) {
                    endCandidates[0] = costs[--endPtr];
                    minHeapify(0, endCandidates, candidates);
                } else {
                    swap(endCandidates, 0, endLimit - 1);
                    minHeapify(0, endCandidates, --endLimit);
                }
            }

            k--;
        }

        return cost;
    }

    
    void buildMinHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            minHeapify(i, arr, arr.length);
        }
    }

    void minHeapify(int index, int[] arr, int limit) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;

        if (left < limit && arr[left] < arr[max]) max = left;
        if (right < limit && arr[right] < arr[max]) max = right;

        if (max == index) return;
        swap(arr, index, max);
        minHeapify(max, arr, limit);
    }


    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


Intuition
Using 2 MinHeaps that store the candidates, one from the start and one from the end of the array. We then pop an element from either of the min heaps and add one element from the middle of the array into the heap. In case adding the middle will make the two heaps collide, we use two new pointer called limits, that signify the end of each heap. This way we only keep a fraction of the "heap" arrays actually heapified.

Complexity
Time complexity:
O((n + k)log(n)) but since k is comparably lesser than n always, the time complexity turns out to be O(nlog(n)), generalized to that of heapifying the lists.

Space complexity:
O(n)



// You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

// You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

// You will run k sessions and hire exactly one worker in each session.
// In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
// For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
// In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
// If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
// A worker can only be chosen once.
// Return the total cost to hire exactly k workers.

 

// Example 1:

// Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
// Output: 11
// Explanation: We hire 3 workers in total. The total cost is initially 0.
// - In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
// - In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8]. The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
// - In the third hiring round we choose the worker from [17,12,10,7,11,20,8]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
// The total hiring cost is 11.
// Example 2:

// Input: costs = [1,2,4,1], k = 3, candidates = 3
// Output: 4
// Explanation: We hire 3 workers in total. The total cost is initially 0.
// - In the first hiring round we choose the worker from [1,2,4,1]. The lowest cost is 1, and we break the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are common in the first and last 3 workers.
// - In the second hiring round we choose the worker from [2,4,1]. The lowest cost is 1 (index 2). The total cost = 1 + 1 = 2.
// - In the third hiring round there are less than three candidates. We choose the worker from the remaining workers [2,4]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
// The total hiring cost is 4.
