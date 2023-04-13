package mylib.datastructures.nodes;

public class TNode {
    int data;
    TNode left;
    TNode right;
    TNode parent;
    int balance;

    // Default constructor
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    // In the TNode class

    public TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }


    // Overloaded constructor
    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.balance = balance;
    }

    // Getter and setter methods
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // Print the node information to console in a user-friendly format
    public void print() {
        System.out.println("Node Info:");
        System.out.println("Data: " + data);
        System.out.println("Balance: " + balance);
        System.out.println("Parent: " + (parent != null ? parent.getData() : "null"));
        System.out.println("Left: " + (left != null ? left.getData() : "null"));
        System.out.println("Right: " + (right != null ? right.getData() : "null"));
    }

    // Returns the data member as a string
    @Override
    public String toString() {
        return Integer.toString(data);
    }
}
