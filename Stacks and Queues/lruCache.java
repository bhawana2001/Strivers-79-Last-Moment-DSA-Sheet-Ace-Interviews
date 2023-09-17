// Problem Statement: “Design a data structure that follows the constraints of Least Recently Used (LRU) cache”.
// Implement the LRUCache class:
// LRUCache(int capacity) we need to initialize the LRU cache with positive size capacity.
// int get(int key) returns the value of the key if the key exists, otherwise return -1.
// Void put(int key,int value), Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.if the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

//Problem Link: https://www.codingninjas.com/studio/problems/lru-cache-implementation_670276?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    Map<Integer, Node> map;        // Map to store key-value pairs for quick access
    Node head;                     // Head node of the linked list representing the most recently used items
    Node tail;                     // Tail node of the linked list representing the least recently used items
    int capacity;                  // Maximum capacity of the cache

    // Initialize a data structure with a specified capacity
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);  // Initialize head node
        tail = new Node(-1, -1);  // Initialize tail node
        head.next = tail;  // Connect head to tail
        tail.prev = head;  // Connect tail to head
        this.capacity = capacity;  // Set the maximum capacity of the cache
    }

    // Move the current node to the head of the linked list, indicating it's the most recently used node (O(1))
    public void moveToHead(Node curr) {
        curr.next = head.next;
        curr.prev = head;
        head.next = curr;
        curr.next.prev = curr;
    }

    // Delete the current node from the linked list (O(1))
    public void delete(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    // Get the value associated with a key from the cache (O(1))
    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            delete(curr);         // Remove the current node from its current position
            moveToHead(curr);     // Move it to the head, indicating it's the most recently used
            return curr.val;      // Return the value associated with the key
        }
        return -1;  // Key not found in the cache
    }

    // Put a new key-value pair into the cache (O(1))
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;      // Update the value associated with the existing key
            delete(curr);          // Remove the current node from its current position
            moveToHead(curr);      // Move it to the head, indicating it's the most recently used
        } else if (map.size() < capacity) {
            map.put(key, new Node(key, value));  // Add a new key-value pair to the cache
            moveToHead(map.get(key));           // Move it to the head, indicating it's the most recently used
        } else {
            map.put(key, new Node(key, value));  // Add a new key-value pair to the cache
            map.remove(tail.prev.key);           // Remove the least recently used key from the map
            delete(tail.prev);                   // Remove the tail node, indicating it's the least recently used
            moveToHead(map.get(key));            // Move the new node to the head
        }
    }
}
