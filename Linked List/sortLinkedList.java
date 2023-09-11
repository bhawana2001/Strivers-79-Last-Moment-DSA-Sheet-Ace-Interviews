//Problem Statement: Given a linked list. Sort the list in non-decreasing order.

//Problem Link: https://www.codingninjas.com/studio/problems/sort-linked-list_625193?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node {
 * public int data;
 * public Node next;
 * 
 * Node()
 * {
 * this.data = 0;
 * this.next = null;
 * }
 * Node(int data)
 * {
 * this.data = data;
 * this.next = null;
 * }
 * Node(int data, Node next)
 * {
 * this.data = data;
 * this.next = next;
 * }
 * }
 * 
 *****************************************************************/

public class sortLinkedList {
    // we will sort list using merge sort
    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find middle node of list to seperate list into two half
        Node middle = findMiddle(head);
        Node left = head; // left list
        Node right = middle.next; // right list
        middle.next = null;
        left = sortList(left); // sort left part
        right = sortList(right); // sort right part
        return merge(left, right); // merge left and right
    }

    // find middle of list using two pointers
    public static Node findMiddle(Node head) {
        if (head == null)
            return null;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge two list
    public static Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node current = dummy;
        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        // if nodes left in left list
        if (left != null) {
            current.next = left;
        }
        // if nodes left in right list
        if (right != null) {
            current.next = right;
        }
        return dummy.next;
    }

}