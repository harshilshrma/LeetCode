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

    private static class Node {
        private int key;
        private int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;

    private Node left;
    private Node right;

    public void LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        this.left  = new Node(0, 0);
        this.right  = new Node(0, 0);
        this.left.next = this.right;
        this.right.next = this.left;
    }

    // helper function
    public void insert(Node node) {
        //
        Node prev = this.right.prev;
        Node next = this.right;

        //
        prev.next = node;
        next.prev = node;

        //
        node.next = next;
        node.prev = prev;
    }

    public void remove(Node node) {
        //
        Node prev = node.prev;
        Node next = node.next;

        //
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {

    }
}

