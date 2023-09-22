//Problem Statement: Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
// Basically, the deletion can be divided into two stages:
// Search for a node to remove.
// If the node is found, delete the node.

//Problem Link: https://www.codingninjas.com/studio/problems/delete-node-in-bst_920381?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

public class deleteNodeInBst {
    // Function to delete a node with a given key from the binary search tree
    public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
        // Base case: If the root is null, return null (end of traversal)
        if (root == null)
            return null;

        // If the current node's data matches the key, call the solve function to delete
        // it
        if (root.data == key)
            return solve(root);

        // Initialize a current node pointer to traverse the tree
        BinaryTreeNode<Integer> curr = root;
        while (curr != null) {
            // If the key is less than the current node's data, move to the left subtree
            if (key < curr.data) {
                // If the left child has the key, call the solve function to delete it
                if (curr.left != null && curr.left.data == key)
                    curr.left = solve(curr.left);
                else
                    curr = curr.left; // Otherwise, move left in the tree
            } else {
                // If the key is greater than or equal to the current node's data, move to the
                // right subtree
                // If the right child has the key, call the solve function to delete it
                if (curr.right != null && curr.right.data == key)
                    curr.right = solve(curr.right);
                else
                    curr = curr.right; // Otherwise, move right in the tree
            }
        }

        return root;
    }

    // Helper function to delete a node with two children
    public static BinaryTreeNode<Integer> solve(BinaryTreeNode<Integer> root) {
        // If the left child is null, return the right child (replacement)
        if (root.left == null)
            return root.right;

        // If the right child is null, return the left child (replacement)
        if (root.right == null)
            return root.left;

        // Find the leftmost node in the right subtree (successor)
        BinaryTreeNode<Integer> lefty = root.left;
        BinaryTreeNode<Integer> righty = root.right;
        while (righty.left != null)
            righty = righty.left;

        // Make the successor's left child point to the left subtree
        righty.left = lefty;
        return root.right; // Return the right subtree as the new root
    }
}
