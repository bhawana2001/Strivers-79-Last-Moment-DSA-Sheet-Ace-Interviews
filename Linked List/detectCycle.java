// Problem Statement: Given head, the head of a linked list, determine if the linked list has a cycle in it.
//  There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Return true if there is a cycle in the linked list. Otherwise, return false.

//Problem Link: https://www.codingninjas.com/studio/problems/cycle-detection-in-a-singly-linked-list_628974?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/*  

    Following is the representation of the Singly Linked List node

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

*/

public class detectCycle {
    public static boolean detectCycle(Node head) {
        // Your code goes here
        if (head == null)
            return false; // if the list is empty
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // if at any point slow and fast are equal that means
            // we have a cycle
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}