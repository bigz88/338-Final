package mylib.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import mylib.datastructures.nodes.TNode;

public class BST {
    TNode root;

    public BST() {
        root = null;
    }

    public BST(int num) {
        root = new TNode(num, 0, null, null, null);
    }

    public BST(TNode obj) {
        root = obj;
    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    public void insert(int num) {
        root = insert(root, num);
    }

    private TNode insert(TNode node, int num) {
        if (node == null) {
            return new TNode(num, 0, null, null, null);
        }

        if (num < node.getData()) {
            node.setLeft(insert(node.getLeft(), num));
        } else if (num > node.getData()) {
            node.setRight(insert(node.getRight(), num));
        }

        return node;
    }

    public void insert(TNode node) {
        root = insert(root, node);
    }

    private TNode insert(TNode root, TNode node) {
        if (root == null) {
            return node;
        }

        if (node.getData() < root.getData()) {
            root.setLeft(insert(root.getLeft(), node));
        } else if (node.getData() > root.getData()) {
            root.setRight(insert(root.getRight(), node));
        }

        return root;
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    private TNode delete(TNode node, int val) {
        if (node == null) {
            System.out.println("Value not found in the tree");
            return null;
        }

        if (val < node.getData()) {
            node.setLeft(delete(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(delete(node.getRight(), val));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setData(minValue(node.getRight()));
            node.setRight(delete(node.getRight(), node.getData()));
        }

        return node;
    }

    private int minValue(TNode node) {
        int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }

    public TNode search(int val) {
        return search(root, val);
    }

    private TNode search(TNode node, int val) {
        if (node == null || node.getData() == val) {
            return node;
        }

        if (val < node.getData()) {
            return search(node.getLeft(), val);
        }

        return search(node.getRight(), val);
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }
    
    private void printInOrder(TNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }

    public void printBF() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
    
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
    
        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            while (nodeCount > 0) {
                TNode node = queue.poll();
                System.out.print(node.getData() + " ");
    
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
                nodeCount--;
            }
            System.out.println();
        }
    }
    

}
   

