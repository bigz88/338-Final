package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class StackLL extends SLL {

    // Constructor
    public StackLL() {
        super();
    }

    public StackLL(DNode node) {
        super(node);
    }

    // Adds an element to the stack
    public void push(int data) {
        DNode newNode = new DNode(data);
        super.insertHead(newNode);
    }

    // Removes and returns the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        int data = head.data;
        super.deleteHead();
        return data;
    }

    // Returns the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return head.data;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of elements in the stack
    public int size() {
        return size;
    }

    // Override unnecessary methods with empty bodies
    @Override
    public void insertTail(DNode node) {
        // Empty body
    }

    @Override
    public void insert(DNode node, int position) {
        // Empty body
    }

    @Override
    public void sortedInsert(DNode node) {
        // Empty body
    }

    @Override
    public void deleteTail() {
        // Empty body
    }

    @Override
    public void delete(int data) {
        // Empty body
    }

    @Override
    public void sort() {
        // Empty body
    }
}

