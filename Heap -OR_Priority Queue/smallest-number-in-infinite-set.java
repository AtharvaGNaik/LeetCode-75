
https://leetcode.com/problems/smallest-number-in-infinite-set/solutions/3455128/java-easy-to-understand-solution-hashmap-and-heap-tc-o-nlogn-sc-o-n

class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq;
    private HashMap<Integer, Integer> hm;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<Integer>();
        hm = new HashMap<Integer, Integer>();
        for(int i=1; i<=1000; i++)
        {
            pq.add(i);
        }
    }
    
    public int popSmallest() {
        hm.put(pq.peek(),1);
        return pq.poll();
    }
    
    public void addBack(int num) {
        if(hm.containsKey(num))
        {
            hm.remove(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
Intuition
The provided solution comes to my mind when i look to constraints given in the question for num(numbers which we can conatins in the set as it given that the maximum value can be 1000).

Approach
First we will create a minHeap/min Priority queue which will intially contains the value present in positive set(which contains all positive integers [1, 2, 3, 4, 5, ...] till 1000 as 1000 is the max limits of numbers that can be present in set).
We will also create a HashMap to keep the track of elements which have been removed from the minHeap therefore it will also keep the track of elements which are present in minHeap.
The elements which are in minHeap would not be in hashMap and vice-versa.
So in SmallestInfiniteSet() we will intialize our minHeap of size 1000 and add 1 to 1000 elements in minHeap and also create a hashmap.
In popSmallest() function we will remove the top most element from minHeap which will be always smallest element present in set and return it.
And then we will also add it to HashMap so that we can use this hashmap while implementing addBack().
In addBack(int num) we will use the hashMap to check if the number which we are adding to the set/minheap is whether present in the set or not, like if the element is present in hashmap then it is not present in set as the hashMap only contains value which are removed from the set.
So if value is present in hashMap then we will remove it from hashMap and add it set/minHeap.

Complexity
Time complexity: O(NlogN)
Space complexity: O(N)


// You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].Implement the SmallestInfiniteSet class:
// SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
// int popSmallest() Removes and returns the smallest integer contained in the infinite set.
// void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
 
// Example 1:
// Input
// ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
// [[], [2], [], [], [], [1], [], [], []]
// Output
// [null, null, 1, 2, 3, null, 1, 4, 5]

// Explanation
// SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
// smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
// smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
// smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
// smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
// smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
// smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
//                                    // is the smallest number, and remove it from the set.
// smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
// smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.
