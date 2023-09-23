//Problem Statement: Find the size of largest BST in a binary tree.

//Problem Link: https://www.codingninjas.com/studio/problems/size-of-largest-bst-in-binary-tree_893103?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    void BinaryTreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    void BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    void BinaryTreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

class BSTInfo {
    int size;
    int min;
    int max;
    boolean isBST;

    BSTInfo(int size, int min, int max, boolean isBST) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

public class sizeOfLargestBst {
    public static int largestBST(TreeNode root) {
        // Write your code here.
        BSTInfo result = findLargestBST(root);
        return result.size;
    }

    private static BSTInfo findLargestBST(TreeNode node) {
        // Base case: If the node is null, return information for an empty tree.
        if (node == null) {
            return new BSTInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        // Recursively find information for left and right subtrees.
        BSTInfo leftInfo = findLargestBST(node.left);
        BSTInfo rightInfo = findLargestBST(node.right);

        // Check if the current subtree is a BST.
        boolean isBST = false;
        if (leftInfo.isBST && rightInfo.isBST && node.data > leftInfo.max && node.data < rightInfo.min) {
            isBST = true;
        }

        // Calculate the size of the BST rooted at the current node.
        int size = isBST ? leftInfo.size + rightInfo.size + 1 : Math.max(leftInfo.size, rightInfo.size);

        // Update min and max values for the current subtree.
        int minVal = Math.min(node.data, Math.min(leftInfo.min, rightInfo.min));
        int maxVal = Math.max(node.data, Math.max(leftInfo.max, rightInfo.max));

        // Return information for the current subtree.
        return new BSTInfo(size, minVal, maxVal, isBST);
    }
}