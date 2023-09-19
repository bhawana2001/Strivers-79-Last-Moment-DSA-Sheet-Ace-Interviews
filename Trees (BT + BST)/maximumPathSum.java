// Problem Statement: Write a program to find the maximum sum path in a binary tree. A path in a binary tree is a sequence of nodes where every adjacent pair of nodes are connected by an edge. A node can only appear in the sequence at most once. A path need not pass from the root. We need to find the path with the maximum sum in the binary tree.

//Problem Link: https://www.codingninjas.com/studio/problems/maximum-sum-path-of-a-binary-tree._1214968?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class maximumPathSum {

    class BinaryTreeNode<T> {
        public T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    // Function to find the maximum path sum in a binary tree
    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        // Create an array to store the maximum path sum (as a reference)
        int[] maxSum = new int[1];

        // Call the helper function to compute the maximum path sum
        maxPathS(root, maxSum);

        // Return the calculated maximum path sum
        return maxSum[0];
    }

    // Helper function to compute the maximum path sum starting from the current
    // node
    public static int maxPathS(BinaryTreeNode<Integer> node, int[] maxValue) {
        // Base case: If the node is null, return 0
        if (node == null) {
            return 0;
        }

        // Calculate the maximum path sum in the left subtree (ignoring negative values)
        int left = Math.max(0, maxPathS(node.left, maxValue));

        // Calculate the maximum path sum in the right subtree (ignoring negative
        // values)
        int right = Math.max(0, maxPathS(node.right, maxValue));

        // Calculate the maximum path sum including the current node
        // Update the maxValue[0] if a better path is found
        maxValue[0] = Math.max(maxValue[0], left + right + node.data);

        // Return the maximum path sum starting from the current node
        return Math.max(left, right) + node.data;
    }
}
