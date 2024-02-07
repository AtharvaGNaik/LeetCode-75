/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solutions/4267916/easy-java-sol-beats-100-backtrackings
class Solution {

    public TreeNode node;

    public boolean check(TreeNode root, TreeNode p){
        if(root==null || p == null){
            return false;
        }
        if(root.val == p.val){
            return true;
        }

        return check(root.left, p) || check(root.right, p);
    }

    public boolean search(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        if(root.val == p.val){
            if(check(p ,q)){
                node = p;
                return false;
            }
            return true;
        }

        if(search(root.left, p, q)){
            if(check(root.right, q)){
                node = root;
            }
            return true;
        }
        if(search(root.right, p, q)){
            if(check(root.left, q)){
                node = root;
            }
            return true;
        }
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        if(node==null){
            search(root, q, p);
        }
        return node;
    }
}

Intuition
The provided code determines the lowest common ancestor (LCA) of two given nodes p and q in a binary tree. The LCA is the deepest node in the tree that has both p and q as descendants.
Approach
The code employs a two-phase approach:

Phase 1: Locate the ancestor of p: The code first searches for the node in the tree that is an ancestor of p. If found, it proceeds to Phase 2.

Phase 2: Check for q in the subtree: In Phase 2, the code checks if the subtree rooted at the ancestor found in Phase 1 contains q. If it does, the ancestor is the LCA, and the code returns it.

Complexity
Time complexity:
The time complexity of the code is O(n)

Space complexity:
The space complexity of the code is O(1)
  
// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

// Example 1
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.

// Example 2:
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

// Example 3:
// Input: root = [1,2], p = 1, q = 2
// Output: 1
