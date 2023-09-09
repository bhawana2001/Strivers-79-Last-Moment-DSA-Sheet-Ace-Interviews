// Problem Statement: Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes,
// return the second middle node.

//Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // find length of list
    public int length(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode middleNode(ListNode head) {
        int len = length(head);
        // if list size is even
        if (len % 2 != 0) {
            int i = 1;
            while (head != null && i <= len / 2) {
                head = head.next;
                i++;
            }
            return head;
        }
        // if list size is odd
        else {
            int i = 1;
            while (head != null && i < len / 2 + 1) {
                head = head.next;
                i++;
            }
            return head;
        }
    }
}