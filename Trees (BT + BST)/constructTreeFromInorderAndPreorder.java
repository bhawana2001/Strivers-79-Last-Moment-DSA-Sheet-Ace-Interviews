//Problem Statement: Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

//Problem Link: https://www.codingninjas.com/studio/problems/construct-binary-tree-from-inorder-and-preorder-traversal_920539?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;
import java.util.Map;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class constructTreeFromInorderAndPreorder {
    // Function to build a binary tree from inorder and preorder traversal arrays
    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        // Create a map to store the indices of elements in the inorder traversal
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // Call the helper function to construct the binary tree
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    // Helper function to build the binary tree recursively
    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> map) {
        // Base case: If the traversal indices are out of bounds, return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // Create a new TreeNode with the current element from preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        // Find the index of the current element in inorder traversal
        int inRoot = map.get(root.data);
        // Calculate the number of elements in the left subtree
        int numsLeft = inRoot - inStart;
        // Recursively build the left and right subtrees
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        // Return the constructed root of the subtree
        return root;
    }
}
