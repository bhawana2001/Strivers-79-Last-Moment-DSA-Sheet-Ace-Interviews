//Problem Statement: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

//Problem Link: https://www.codingninjas.com/studio/problems/lca-of-binary-tree_920541?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

public class lowestCommonAncestor {
    // Function to find the lowest common ancestor of two nodes in a binary tree
    public static int lowestCommonAncestor1(TreeNode<Integer> root, int x, int y) {
        // Call the helper function to find the LCA
        TreeNode<Integer> res = lca(root, x, y);
        // Return the data value of the LCA node
        return res.data;
    }

    // Helper function to find the lowest common ancestor recursively
    public static TreeNode<Integer> lca(TreeNode<Integer> root, int x, int y) {
        // Base case: If the root is null or one of the nodes is found at the current
        // root, return the root
        if (root == null || root.data == x || root.data == y) {
            return root;
        }

        // Recursively search for the nodes in the left and right subtrees
        TreeNode<Integer> left = lca(root.left, x, y);
        TreeNode<Integer> right = lca(root.right, x, y);

        // If one node is found in the left subtree and the other in the right subtree,
        // return the root
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root; // If both nodes are found in different subtrees, return the current root as the
                         // LCA
        }
    }
}
