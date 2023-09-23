//Problem Statement: Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

//Problem Link: https://www.codingninjas.com/studio/problems/pair-sum-in-bst._920493?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
import java.util.*;

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

public class pairSumInBst {
    // Function to check if there exists a pair of nodes in the binary search tree
    // that sums up to 'k'

    public static boolean pairSumBstUsingStacks(TreeNode root, int k) {
        if (root == null) {
            return false; // Empty tree, no pair exists
        }

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode leftCurr = root;
        TreeNode rightCurr = root;

        while (!leftStack.isEmpty() || !rightStack.isEmpty() || leftCurr != null ||
                rightCurr != null) {
            // Build the left stack (in-order)
            while (leftCurr != null) {
                leftStack.push(leftCurr);
                leftCurr = leftCurr.left;
            }
            // Build the right stack (reverse in-order)
            while (rightCurr != null) {
                rightStack.push(rightCurr);
                rightCurr = rightCurr.right;
            }

            if (leftStack.isEmpty() || rightStack.isEmpty()) {
                break; // No more elements to compare
            }

            TreeNode leftNode = leftStack.peek();
            TreeNode rightNode = rightStack.peek();
            if (leftNode == rightNode) {
                break; // Avoid comparing the same node
            }

            int sum = leftNode.data + rightNode.data;
            if (sum == k) {
                return true; // Pair found
            } else if (sum < k) {
                // Move left
                leftStack.pop();
                leftCurr = leftNode.right;
            } else {
                // Move right
                rightStack.pop();
                rightCurr = rightNode.left;
            }
        }

        return false; // No pair found

    }

    public static boolean pairSumBstUsingTwoPointer(TreeNode root, int k) {
        // Create a list to store the inorder traversal of the binary search tree
        List<Integer> in = new ArrayList<>();
        // Perform inorder traversal to populate the list 'in' in sorted order
        inorder(root, in);

        // Initialize two pointers, 'start' at the beginning and 'end' at the end of
        // the
        // list
        int start = 0;
        int end = in.size() - 1;

        // Perform a two-pointer approach to find the pair sum
        while (start <= end) {
            int sum = in.get(start) + in.get(end);
            // If the sum matches 'k', return true (pair found)
            if (sum == k) {
                return true;
            }
            // If the sum is greater than 'k', decrement 'end' to reduce the sum
            else if (sum > k) {
                end--;
            }
            // If the sum is less than 'k', increment 'start' to increase the sum
            else {
                start++;
            }
        }
        // If no pair is found, return false
        return false;
    }

    // Helper function to perform inorder traversal and populate the list 'in'
    public static void inorder(TreeNode root, List<Integer> in) {
        // Base case: If the root is null, return (end of traversal)
        if (root == null)
            return;
        // Recursively traverse the left subtree
        inorder(root.left, in);
        // Add the data of the current node to the list 'in'
        in.add(root.data);
        // Recursively traverse the right subtree
        inorder(root.right, in);
    }
}
