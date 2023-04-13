package mylib;

import mylib.datastructures.linear.CDLL;
import mylib.datastructures.linear.CSLL;
import mylib.datastructures.linear.DLL;
import mylib.datastructures.linear.SLL;
import mylib.datastructures.nodes.DNode;
import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;
import mylib.datastructures.trees.BST;

public class Main {
    static void SLLTests(){
        System.out.println("-*-*-*-SLL TESTS-*-*-*-\n");
        DNode node = new DNode(10);
        DNode node1 = new DNode(20);
        DNode node2 = new DNode(30);
        DNode node3 = new DNode(25);
        SLL test = new SLL(node);
        SLL test1 = new SLL();
        // Testing methods:
        System.out.println("For test (Overloaded CTOR)");
        test.insert(node1, 1);
        test.insert(node2, 2);
        test.insert(node3, 3);
        test.print();
        System.out.println("\nFor test (Default CTOR)");
        test1.insertHead(node2);
        test1.insert(node1, 1);
        test1.insert(node3, 2);
        test1.print();
        System.out.println("\nTesting searching:");
        System.out.println(test.search(10).data); // Expected 10
        System.out.println("\nTesting sorting");
        test.sort();
        test.print();
        System.out.println("\nTesting removal");
        test.delete(node2.data);
        test.deleteHead();
        test.deleteTail();
        test.print();
    }
    static void DLLTests(){
        System.out.println("\n-*-*-*-DLL TESTS-*-*-*-\n");
        DNode node = new DNode(2);
        DNode node1 = new DNode(10);
        DNode node2 = new DNode(4);
        DNode node3 = new DNode(1);
        DNode node4 = new DNode(12);
        DLL test = new DLL(node);
        DLL test1 = new DLL();
        // Testing methods:
        System.out.println("For test (Overloaded CTOR)");
        test.insert(node1, 1);
        test.insert(node2, 2);
        test.insert(node3, 3);
        test.insert(node4, 4);
        test.print();
        System.out.println("\nFor test (Default CTOR)");
        test1.insertHead(node2);
        test1.insert(node1, 1);
        test1.insert(node3, 2);
        test1.print();
        System.out.println("\nTesting sorting");
        test.sort();
        test.print();
        System.out.println("\nTesting searching");
        System.out.println(test.search(10).data); // Expected 10
        System.out.println("\nTesting removal");
        test.delete(node2.data);
        test.deleteHead();
        test.deleteTail();
        test.print();
    }
    static void CSLLTests(){
        System.out.println("\n-*-*-*-CSLL TESTS-*-*-*-\n");
        CSLL csll = new CSLL();
        // insert nodes
        csll.insertHead(new DNode(10));
        csll.insertHead(new DNode(9));
        csll.insertTail(new DNode(8));
        csll.insert(new DNode(4), 1);
        csll.insert(new DNode(5), 3);
        // print the list
        System.out.println("List after insertion:");
        csll.print();
        // search for a node
        DNode node = csll.search(3);
        if (node != null) {
            System.out.println("Found node with data: " + node.data);
        } else {
            System.out.println("Node not found");
        }
        DNode node1 = csll.search(9);
        if (node1 != null) {
            System.out.println("Found node with data: " + node1.data);
        } else {
            System.out.println("Node not found");
        }
        // sort
        csll.sort();
        csll.print();
        // delete nodes
        csll.deleteHead();
        csll.deleteTail();
        csll.delete(4);
        // print the list
        System.out.println("List after deletion:");
        csll.print();
    }
    static void CDLLTests(){
        System.out.println("\n-*-*-*-CDLL TESTS-*-*-*-\n");
        CDLL cdll = new CDLL();
        // insert nodes
        cdll.insertHead(new DNode(10));
        cdll.insertHead(new DNode(9));
        cdll.insertTail(new DNode(8));
        cdll.insert(new DNode(4), 1);
        cdll.sortedInsert(new DNode(5));
        // print the list
        System.out.println("List after insertion:");
        cdll.print();
        // search for a node
        DNode node = cdll.search(3);
        if (node != null) {
            System.out.println("Found node with data: " + node.data);
        } else {
            System.out.println("Node not found");
        }
        DNode node1 = cdll.search(10);
        if (node1 != null) {
            System.out.println("Found node with data: " + node1.data);
        } else {
            System.out.println("Node not found");
        }
        // delete nodes
        cdll.deleteHead();
        cdll.deleteTail();
        cdll.delete(4);
        // print the list
        System.out.println("List after deletion:");
        cdll.print();
    }
    static void AVLTests(){
        System.out.println("\n-*-*-*-AVL TESTS-*-*-*-\n");
        AVL avl = new AVL();

        // Insert elements into the tree
        avl.insert(50);
        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.insert(70);
        avl.insert(60);
        avl.insert(80);

        // Print the tree in ascending order
        System.out.println("In order traversal:");
        avl.printInOrder();

        // Print the tree in Breadth-First order
        System.out.println("Breadth-First order traversal:");
        avl.printBF();

        // Search for a value in the tree
        System.out.println("Testing if values are present:");
        int valueToSearch = 40;
        int valueToSearch1 = 12;
        TNode foundNode = avl.search(valueToSearch);
        if (foundNode != null) {
            System.out.println("Value " + valueToSearch + " found in the tree");
        } else {
            System.out.println("Value " + valueToSearch + " not found in the tree");
        }
        TNode foundNode1 = avl.search(valueToSearch1);
        if (foundNode1 != null) {
            System.out.println("Value " + valueToSearch1 + " found in the tree");
        } else {
            System.out.println("Value " + valueToSearch1 + " not found in the tree");
        }
    }
    static void BSTTests(){
        System.out.println("\n-*-*-*-BST TESTS-*-*-*-\n");

        BST bst = new BST();

        bst.insert(10);
        bst.insert(5);
        bst.insert(17);
        bst.insert(12);
        bst.insert(20);
        bst.insert(2);

        System.out.print("In order traversal: ");
        bst.printInOrder();
        System.out.println("Breadth-first traversal:");
        bst.printBF();

        System.out.println("Testing if 30 and 2 are in the tree:");
        TNode node = bst.search(30);
        if (node != null) {
            System.out.println("Found node with value 30");
        } else {
            System.out.println("Could not find node with value 30");
        }
        TNode node1 = bst.search(2);
        if (node1 != null) {
            System.out.println("Found node with value 2");
        } else {
            System.out.println("Could not find node with value 2");
        }
        bst.delete(5);
        System.out.println("Tree after deleting 5:");
        bst.printBF();
    }
    public static void main(String[] args) {
        SLLTests();
        DLLTests();
        CSLLTests();
        CDLLTests();
        AVLTests();
        BSTTests();
    }
}