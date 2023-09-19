// Problem Statement: Find the Diameter of a Binary Tree. Diameter is the length of the longest path between any 2 nodes in the tree and this path may or may not pass from the root.

//Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/

//  * Definition for a binary tree node.
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Method to calculate the diameter of a binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        // Create an array to store the diameter value (as a reference)
        int[] diameter = new int[1];

        // Call the height function to compute the diameter
        height(root, diameter);

        // Return the calculated diameter
        return diameter[0];
    }

    // Method to calculate the height of a binary tree
    public int height(TreeNode root, int[] diameter) {
        // Base case: If the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = height(root.left, diameter);
        int rightHeight = height(root.right, diameter);

        // Update the diameter if necessary (sum of left and right subtree heights)
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        // Return the height of the current subtree (1 + maximum of left and right
        // subtree heights)
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
