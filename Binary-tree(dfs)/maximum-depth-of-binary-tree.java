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
 */class Solution {
    public int maxDepth(TreeNode root) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }
}

// Let's understand this with an tree example.

// Say we have given something like this :-

// image

// To calculate it's height, we draw line and found out that it's height is 3

// Now, by using recursion how can we find it. So, we know the root & it's child will be find by Hypothesis. So we go deep inside to it's left, then to it's right & from there we will get the deepest root to child value of it's left & right. We will compare both of them and that will be our Induction and which one has the greatest value will be added to 1, as root will count as well.
// Now in this the smallest valid Input could be if root is null & that;s our Base condition. Let's understand visually

// image

// In the above diagram, max height we get is 3. But we have to add root as well. So, it will be 3 + 1 = 4

// Now let's code it up :-



//   Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: 3
// Example 2:

// Input: root = [1,null,2]
// Output: 2
 
