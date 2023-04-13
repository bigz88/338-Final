package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class QueueLL extends SLL {

    public QueueLL() {
        super();
    }

    public QueueLL(DNode node) {
        super(node);
    }

    // Override any methods that do not apply to queues with an empty body
    @Override
    public void insertHead(DNode node) {
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
    public void delete(int data) {
        // Empty body
    }

    @Override
    public void sort() {
        // Empty body
    }

    // Define function wrappers with proper naming conventions
    public void enqueue(int data) {
        DNode newNode = new DNode(data);
        super.insertTail(newNode);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = super.head.data;
        super.deleteHead();
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return super.head.data;
    }

    public boolean isEmpty() {
        return super.size == 0;
    }

    public int size() {
        return super.size;
    }

    public void print() {
        super.print();
    }
}
