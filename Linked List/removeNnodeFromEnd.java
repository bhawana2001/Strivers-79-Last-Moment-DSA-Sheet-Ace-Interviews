// Problem Statement: Given a linked list, and a number N. Find the Nth node from the end of this linked list and delete it.
// Return the head of the new modified linked list.

//Problem Link: https://www.codingninjas.com/studio/problems/delete-kth-node-from-end_799912?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node next;
 * public Node prev;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.next = null;
 * this.prev = null;
 * }
 * 
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * this.prev = null;
 * }
 * 
 * Node(int data, Node next)
 * {
 * this.data = data;
 * this.next = next;
 * this.prev = next;
 * }
 * };
 * 
 *****************************************************************/

public class removeNnodeFromEnd {
    public static Node removeKthNode(Node head, int K) {
        if (head == null)
            return head;
        int len = length(head);
        // find distance of node from start
        int dis = len - K;
        int i = 0;
        Node prev = new Node(-1);
        Node res = prev;
        while (head.next != null && i < dis) {
            res.next = head;
            head = head.next;
            res = res.next;
            i++;
        }
        res.next = head.next;
        return prev.next;
    }

    // find length of list
    public static int length(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}