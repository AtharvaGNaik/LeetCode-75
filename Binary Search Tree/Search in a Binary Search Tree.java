class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
   
        if(root == null)return null;//Base Condition(If tree is empty )
        while (root != null && root.val !=val){//Tree is not empty and root value is not equals to val
            root = val <root.val?root.left :root.right;//terminatory condition if val smaller than root value then search in left side else on right side
        }
        return root;  
    }
}
// BINARY SEARCH TREE (BST) is a node-based binary tree data structure which has the properties:

// The left subtree of a node contains only nodes with keys lesser than the node’s key.
// The right subtree of a node contains only nodes with keys greater than the node’s key.
// The left and right subtree each must also be a binary search tree.

// You are given the root of a binary search tree (BST) and an integer val.
// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

// Example 1:
// Input: root = [4,2,7,1,3], val = 2
// Output: [2,1,3]

// Example 2:
// Input: root = [4,2,7,1,3], val = 5
// Output: []
 
