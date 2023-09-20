// Problem Statement: Given a binary tree, print the bottom view from left to right. A node is included in the bottom view if it can be seen when we look at the tree from the bottom.

//Problem Link: https://www.codingninjas.com/studio/problems/bottom-view-of-binary-tree_893110?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    int hd; // Horizontal distance
    TreeNode root; // TreeNode

    public Pair(int hd, TreeNode root) {
        this.hd = hd;
        this.root = root;
    }
}

public class bottomViewOfTree {
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>(); // TreeMap to maintain sorted order

        if (root == null)
            return ans;

        q.add(new Pair(0, root)); // Add root with horizontal distance 0

        while (!q.isEmpty()) {
            Pair temp = q.remove(); // Dequeue a pair
            map.put(temp.hd, temp.root.val); // Store node value in TreeMap

            // Enqueue left child with adjusted horizontal distance (hd - 1)
            if (temp.root.left != null) {
                q.add(new Pair(temp.hd - 1, temp.root.left));
            }

            // Enqueue right child with adjusted horizontal distance (hd + 1)
            if (temp.root.right != null) {
                q.add(new Pair(temp.hd + 1, temp.root.right));
            }
        }

        // Extract values from the TreeMap (sorted by hd) to get the bottom view
        for (int value : map.values()) {
            ans.add(value); // Add values to the result list
        }

        return ans;
    }
}
