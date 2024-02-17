
https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/4542930/mastering-the-symphony-of-minheap-easiest-way-100-easy

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }
}


Intuition
The intuition behind this approach is to maintain a minheap (priority queue) of size K while iterating through the array. Doing this ensures that the min heap always contains the K largest elements encountered so far.

Approach
Are you ready to embark on a mesmerizing journey through the enchanting world of minHeap, where algorithms dance in harmony to unveil the secrets of the Kth largest element? 🎩💃

Behold, as we weave a tale of elegance and efficiency, creating a minHeap (a priority queue) that orchestrates the perfect melody to discover the Kth largest gem in an array.

Picture this – our array, a canvas of musical notes waiting to be explored. As we traverse through the notes, we delicately add each element to our minHeap, ensuring a crescendo of order and priority. But ah, the dance is not complete without a touch of suspense!

With every new addition, we perform a graceful check – is the size of our minHeap exceeding the desired Kth largest element? If not, the melody continues to play. However, if the crescendo becomes too grand, fear not! We gracefully remove the smallest note from the heap, leaving only the most harmonious tones behind.

As the symphony of traversal concludes, only three notes remain in our minHeap – a trio of contenders for the coveted title of Kth largest element. With bated breath, we reveal the crescendo's climax – the topmost note in the minHeap, the undisputed Kth largest element, emerges as the star of our algorithmic masterpiece.

In the grand finale, our minHeap stands as a testament to the power of precision and elegance in unraveling complex problems. The audience applauds the efficiency, the finesse, and the sheer brilliance of the Kth largest element revealed through the magical dance of algorithms.

And so, dear readers, join us in this dazzling performance where code meets creativity, and the minHeap takes center stage in the enchanting ballet of algorithmic artistry. 🌟🎭 #AlgorithmicElegance #KthLargestRevealed

Complexity
Time complexity:
The worst case time complexity will be O(NlogK) where N is total no of elements.

Space complexity:
Auxillary Space : O(k)



// Given an integer array nums and an integer k, return the kth largest element in the array.Note that it is the kth largest element in the sorted order, not the kth distinct element.Can you solve it without sorting?

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
