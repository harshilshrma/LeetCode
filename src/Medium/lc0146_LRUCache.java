// Date: 28 December 2023
// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Implement the LRUCache class:
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value
// pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

package Medium;

import java.util.HashMap;
import java.util.Map;

public class lc0146_LRUCache {

    // Declarations
    private Map<Integer, Node> cache; // Map to store cache entries
    private int capacity; // Maximum capacity of the cache

    private Node left; // Sentinel node for the least recently used entry
    private Node right; // Sentinel node for the most recently used entry

    // Constructor to initialize the LRUCache
    public void LRUCache(int capacity) {
        this.capacity = capacity; // Set the maximum capacity
        cache = new HashMap<>(); // Initialize the cache as a HashMap

        // Initialize sentinel nodes to manage the linked list
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // Get function to retrieve a value based on a given key
    public int get(int key) {
        if (cache.containsKey(key)) { // Check if the key exists in the cache
            remove(cache.get(key)); // Remove the node from its current position
            insert(cache.get(key)); // Insert the node to the front of the list (most recent)
            return cache.get(key).val; // Return the value associated with the key
        } else {
            return -1; // Return -1 if the key doesn't exist in the cache
        }
    }

    // Put function to update or add a key-value pair in the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) { // Check if the key exists in the cache
            remove(cache.get(key)); // Remove the existing node
        }
        cache.put(key, new Node(key, value)); // Put the new key-value pair in the cache
        insert(cache.get(key)); // Insert the new node to the front of the list

        if (cache.size() > capacity) { // Check if the cache size exceeds the capacity
            Node lru = this.left.next; // Find the least recently used node
            remove(lru); // Remove the least recently used node from the linked list
            cache.remove(lru.key); // Remove the least recently used entry from the cache
        }
    }

    // Remove a node from the linked list
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    // Insert a node at the front of the list (most recent)
    public void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;

        prev.next = node;
        next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    // Node class to represent entries in the cache with key-value pairs
    private class Node {
        private int key;
        private int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

