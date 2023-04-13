package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class DLL extends SLL {
    protected DNode head;
    protected DNode tail;

    public DLL() {
        super();
    }

    public DLL(DNode head) {
        super(head);
    }

    @Override
    public void insertHead(DNode node) {
        node.next = head;
        if (head == null) {
            tail = node;
        }
        else {
            head.prev = node;
        }
        head = node;
        size++;
    }

    @Override
    public void insertTail(DNode node) {
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    @Override
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
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            node.next = current.next;
            node.prev = current;
            current.next.prev = node;
            current.next = node;
            size++;
        }
    }

    @Override
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
        tail = getLastNode(sortedList);
    }

    private DNode insertIntoSortedList(DNode sortedList, DNode node) {
        if (sortedList == null || sortedList.data >= node.data) {
            node.next = sortedList;
            if (sortedList != null) {
                sortedList.prev = node;
            }
            return node;
        } else {
            DNode current = sortedList;
            while (current.next != null && current.next.data < node.data) {
                current = current.next;
            }
            node.next = current.next;
            node.prev = current;
            if (current.next != null) {
                current.next.prev = node;
            }
            current.next = node;
            return sortedList;
        }
    }

    private DNode getLastNode(DNode listHead) {
        if (listHead == null) {
            return null;
        }
        DNode current = listHead;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    @Override
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
            node.prev = current;
            if (current.next != null) {
                current.next.prev = node;
            } else {
                tail = node;
            }
            current.next = node;
            size++;
        }
    }

    @Override
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


    @Override
    public void deleteHead() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
        }
    }

    @Override
    public void deleteTail() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            size--;
        }
    }

    @Override
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
                current.next.next.prev = current;
                current.next = current.next.next;
                size--;
            }
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
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

    @Override
    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Sorted" : "Unsorted"));
        System.out.print("List content: ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " <-> " : ""));
            current = current.next;
        }
        System.out.println();
    }

}
