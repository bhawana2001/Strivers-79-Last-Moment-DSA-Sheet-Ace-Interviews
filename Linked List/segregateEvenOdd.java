//Problem Statement: Segregate even and odd nodes in a linked list.

//Problem Link: https://www.codingninjas.com/studio/problems/segregate-even-and-odd-nodes-in-a-linked-list_1116100?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

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

public class segregateEvenOdd {
    public static Node segregateEvenOdd(Node head) {
        // Write Your Code Here.
        if (head == null || head.next == null) {
            return head;
        }
        // create two lists for even and odd
        Node evenHead = new Node(0);
        Node oddHead = new Node(0);

        Node even = evenHead;
        Node odd = oddHead;

        Node current = head;

        while (current != null) {
            // if current node is even
            if (current.data % 2 == 0) {
                even.next = current;
                even = even.next;
            }
            // if current node is odd
            else {
                odd.next = current;
                odd = odd.next;
            }
            current = current.next;
        }

        // Connect the even and odd lists
        even.next = oddHead.next; // attach odd list to the tail of even list
        odd.next = null; // end of odd list will be null

        return evenHead.next;
    }
}