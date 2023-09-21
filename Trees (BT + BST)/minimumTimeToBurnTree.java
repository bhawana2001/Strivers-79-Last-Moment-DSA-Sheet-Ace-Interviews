// Problem Statement: You are given a binary tree with distinct node values and a starting node 'start'. The tree is on fire, and it takes 1 unit of time for the fire to spread from a node to any of its neighboring nodes (parent, left child, or right child).
// Your task is to calculate the minimum time required for the entire tree to be engulfed in flames, starting from the node with value 'start'. Write a function 'timeToBurnTree' that takes the root of the binary tree and the starting node value 'start' as input and returns the minimum time needed for the entire tree to burn.

//Problem Link: https://www.codingninjas.com/studio/problems/time-to-burn-tree_1469067?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class minimumTimeToBurnTree {
    // Function to calculate the time it takes to burn a binary tree from a given
    // start node
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        // HashMap to store parent-child relationships
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> par = new HashMap<>();
        // Find parent-child relationships
        findParent(root, par);

        // HashMap to track visited nodes during traversal
        HashMap<BinaryTreeNode<Integer>, Boolean> vis = new HashMap<>();
        // Find the starting node
        BinaryTreeNode<Integer> target = findStart(root, start);

        // Queue for breadth-first traversal
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        int ans = 0;

        // Perform breadth-first traversal
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                BinaryTreeNode<Integer> temp = q.poll();

                // Check and enqueue neighboring nodes
                if (par.containsKey(temp) && !vis.containsKey(par.get(temp))) {
                    vis.put(par.get(temp), true);
                    q.add(par.get(temp));
                }
                if (temp.left != null && !vis.containsKey(temp.left)) {
                    vis.put(temp.left, true);
                    q.add(temp.left);
                }
                if (temp.right != null && !vis.containsKey(temp.right)) {
                    vis.put(temp.right, true);
                    q.add(temp.right);
                }
            }
            ans++;
        }

        // Subtract 1 to get the time excluding the initial start node
        return ans - 1;
    }

    // Function to find parent-child relationships
    public static void findParent(BinaryTreeNode<Integer> target,
            HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> par) {
        if (target == null)
            return;

        if (target.left != null)
            par.put(target.left, target);
        if (target.right != null)
            par.put(target.right, target);

        findParent(target.left, par);
        findParent(target.right, par);
    }

    // Function to find the starting node
    public static BinaryTreeNode<Integer> findStart(BinaryTreeNode<Integer> target, int start) {
        if (target == null)
            return null;

        if (target.data == start)
            return target;

        BinaryTreeNode<Integer> leftResult = findStart(target.left, start);
        if (leftResult == null) {
            return findStart(target.right, start);
        }
        return leftResult;
    }
}
