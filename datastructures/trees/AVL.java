package mylib.datastructures.trees;
import mylib.datastructures.nodes.TNode;

import java.util.LinkedList;
import java.util.Queue;


public class AVL extends BST {
    public AVL() {
        super();
    }

    public AVL(int num) {
        super(num);
    }
    public AVL(TNode obj) {
        super(createBalancedTree(obj));
    }

    @Override
    public void setRoot(TNode obj) {
        super.setRoot(createBalancedTree(obj));
    }

    private static TNode createBalancedTree(TNode obj) {
        AVL avl = new AVL();
        Queue<TNode> queue = new LinkedList<>();
        queue.add(obj);
        while (!queue.isEmpty()) {
            TNode current = queue.poll();
            avl.insert(current.getData());

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return avl.getRoot();
    }

    private TNode insert(TNode root, int num) {
        TNode newNode = new TNode(num);
        return insert(root, newNode);
    }
    

    @Override
    public void insert(int num) {
            super.setRoot(insert(super.getRoot(), num));
        }   

    @Override
    public void insert(TNode node) {
        super.setRoot(insert(super.getRoot(), node));
    }
    
    protected TNode insert(TNode root, TNode node) {
        if (root == null) {
            return node;
        }
        if (node.getData() < root.getData()) {
            root.setLeft(insert(root.getLeft(), node));
        } else if (node.getData() > root.getData()) {
            root.setRight(insert(root.getRight(), node));
        } else {
            return root;
        }
        root.setBalance(getHeight(root.getLeft()) - getHeight(root.getRight()));

        if (root.getBalance() > 1) {
            if (node.getData() > root.getLeft().getData()) {
                root.setLeft(rotateLeft(root.getLeft()));
            }
            return rotateRight(root);
        }
        if (root.getBalance() < -1) {
            if (node.getData() < root.getRight().getData()) {
                root.setRight(rotateRight(root.getRight()));
            }
            return rotateLeft(root);
        }
        return root;
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
            return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    private TNode rotateLeft(TNode node) {
        TNode node1 = node.getRight();
        TNode temp = node1.getLeft();
        node1.setLeft(node);
        node.setRight(temp);
        node.setBalance(getHeight(node.getLeft()) - getHeight(node.getRight()));
        node1.setBalance(getHeight(node1.getLeft()) - getHeight(node1.getRight()));
        return node1;
    }

    private TNode rotateRight(TNode node) {
        TNode node1 = node.getLeft();
        TNode temp = node1.getRight();
        node1.setRight(node);
        node.setLeft(temp);
        node.setBalance(getHeight(node.getLeft()) - getHeight(node.getRight()));
        node1.setBalance(getHeight(node1.getLeft()) - getHeight(node1.getRight()));
        return node1;
    }
}    

