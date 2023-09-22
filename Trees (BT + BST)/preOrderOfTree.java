//Problem Statement: Given the root of a binary tree, return the preorder traversal of its nodes' values.

//Problem Link: https://www.codingninjas.com/studio/problems/preorder-binary-tree_5948?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class preOrderOfTree {

    // Function to perform preOrder traversal of a binary tree
    public static void preOrder(BinaryTreeNode<Integer> root) {
        // Base case: If the root is null, return (end of traversal)
        if (root == null) {
            return;
        }
        // Print the data of the current root node
        System.out.print(root.data + " ");
        // Recursively traverse the left subtree
        preOrder(root.left);
        // Recursively traverse the right subtree
        preOrder(root.right);
    }
}
