https://leetcode.com/problems/path-sum-iii/solutions/4274495/beats-100-00-of-users-with-java-easy-dfs-code-o-n-tc-with-explanation


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Map for keeping track of (PrefixSum, timesPrefixSumSeen) during traversal
    Map<Long, Integer> hmap;
    int count;

    public int pathSum(TreeNode root, int targetSum) {
        hmap = new HashMap<>();
        count = 0;

        dfs(root, 0, targetSum);

        return count;
    }

    private void dfs(TreeNode root, long prefixSum, int targetSum) {
        // base case
        if (root == null) return;

        
        prefixSum += root.val;
        
        // If map contains a sum equal to (prefixSum - targetSum), we need to increment count that many times
        if (hmap.containsKey(prefixSum-targetSum)) {
            count += hmap.get(prefixSum-targetSum);
        } 
        
        // There can be cases when the prefixSum is directly equal to targetSum, we need to increment count
        if (targetSum == prefixSum) {
            count++;
        }

        // Update the prefixSum till current node and it's count
        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

        // Recurse
        dfs(root.left, prefixSum, targetSum);
        dfs(root.right, prefixSum, targetSum);

        // Backtrack
        hmap.put(prefixSum, hmap.get(prefixSum) - 1);
        
    }
} 


Intuition
The intuition behind this code is to use a hash table to keep track of the prefix sums that we have seen so far during the traversal of the tree. For each node, we check if the hash table contains a sum equal to (prefixSum - targetSum). If it does, then we know that there exists a path from the root node to the current node with a sum equal to targetSum.

Approach
Initialize a hash table to store the prefix sums that we have seen so far during the traversal of the tree.
Initialize a counter variable to keep track of the number of paths from the root node to the current node with a sum equal to targetSum.
Perform a recursive traversal of the tree. For each node:
Update the prefix sum by adding the value of the current node.

Check if the hash table contains a sum equal to (prefixSum - targetSum). *If it does, then increment the counter variable.

If the prefix sum is equal to targetSum, then increment the counter variable.

Update the hash table to store the current prefix sum and its count.

Recursively traverse the left and right subtrees of the current node.

Backtrack by removing the current prefix sum and its count from the hash table.

Complexity
Time complexity:
The time complexity of this code is O(n), where n is the number of nodes in the tree. This is because we need to visit each node in the tree once.

Space complexity:
The space complexity of this code is O(n), where n is the number of nodes in the tree. This is because we need to store the prefix sums in the hash table.


// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
// The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

// Example 1:

// Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// Output: 3
// Explanation: The paths that sum to 8 are shown.

// Example 2:
  
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: 3
