// Problem Statement: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
// If the two linked lists have no intersection at all, return null.

//Problem Link: https://www.codingninjas.com/studio/problems/-intersection-of-two-linked-lists_630457?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

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

public class intersectionPointOfTwoList {
    public static int findIntersection(Node firstHead, Node secondHead) {
        // FIRST APPROACH - USING LENGTH VARIABLE
        int first = length(firstHead);
        int second = length(secondHead);
        // if firstHead is greater then second
        // we decrease the size of firstHead until it becomes equal
        while (first > second) {
            first--;
            firstHead = firstHead.next;
        }
        // if firstHead is smaller then second
        // we decrease the size of secondHead until it becomes equal
        while (second > first) {
            second--;
            secondHead = secondHead.next;
        }
        // now after above steps we will have both list of same size
        // so we can iterate over nodes, and check if at any point we have both nodes
        // are equal
        // that means ,we found our intersection point
        while (firstHead != null && secondHead != null) {
            if (firstHead == secondHead) {
                return firstHead.data;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return -1; // not found
        // SECOND APPROACH - USING DUMMY NODES
        Node dummy1 = firstHead;
        Node dummy2 = secondHead;

        while (dummy1 != dummy2) {
            // if at any point any no0de becomes null
            // interchange them
            dummy1 = dummy1 == null ? secondHead : dummy1.next;
            dummy2 = dummy2 == null ? firstHead : dummy2.next;
        }

        return dummy1.data;

    }

    // length of list
    public static int length(Node head) {
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}