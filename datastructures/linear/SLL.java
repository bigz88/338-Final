package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class SLL {
    protected DNode head;
    protected DNode tail;
    protected int size;

    public SLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public SLL(DNode head) {
        this.head = head;
        this.tail = head;
        size = 1;
    }

    public void insertHead(DNode node) {
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    public void insertTail(DNode node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void insert(DNode node, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            size++;
        }
    }

    public void sortedInsert(DNode node) {
        if (!isSorted()) {
            sort();
        }
    
        if (head == null || head.data >= node.data) {
            insertHead(node);
        } else {
            DNode current = head;
            while (current.next != null && current.next.data < node.data) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            if (current == tail) {
                tail = node;
            }
            size++;
        }
    }
    
    public DNode search(int data) {
        DNode current = head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void deleteHead() {
        if (head != null) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        }
    }
    
    public void deleteTail() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                DNode current = head;
                while (current.next != tail) {
                    current = current.next;
                }
                current.next = null;
                tail = current;
            }
            size--;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            deleteHead();
            return;
        }
        DNode current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            if (current.next == tail) {
                deleteTail();
            } else {
                current.next = current.next.next;
                size--;
            }
        }
    }
    
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        DNode sortedList = null;
        DNode current = head;
        while (current != null) {
            DNode nextNode = current.next;
            sortedList = insertIntoSortedList(sortedList, current);
            current = nextNode;
        }
        head = sortedList;
    }
    
    private DNode insertIntoSortedList(DNode sortedList, DNode node) {
        if (sortedList == null || sortedList.data >= node.data) {
            node.next = sortedList;
            return node;
        } else {
            DNode current = sortedList;
            while (current.next != null && current.next.data < node.data) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            return sortedList;
        }
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public boolean isSorted() {
        if (head == null || head.next == null) {
            return true;
        }
        DNode current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
    
    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Sorted" : "Unsorted"));
        System.out.print("List content: ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }
}
    
               
    
    