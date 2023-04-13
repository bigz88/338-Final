package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CSLL extends SLL {
    
    public CSLL() {
        super();
    }

    public CSLL(DNode head) {
        super(head);
        if (head != null) {
            head.next = head;
        }
    }

    @Override
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
        size++;
    }

    @Override
    public void insertTail(DNode node) {
        if (head == null) {
            insertHead(node);
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
            size++;
        }
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
            current.next = node;
            size++;
        }
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
            while (current.next != head && current.next.data < node.data) {
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

    @Override
    public DNode search(int data) {
        if (head == null) {
            return null;
        }
        DNode current = head;
        do {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        } while (current != head);
        return null;
    }

    @Override
    public void deleteHead() {
        if (head != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            size--;
        }
    }

    @Override
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
                tail = current;
                tail.next = head;
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
        while (current.next != head && current.next.data != data) {
            current = current.next;
        }
        if (current.next != head) {
            if (current.next == tail) {
                deleteTail();
            } else {
                current.next = current.next.next;
                size--;
            }
        }
    }

    @Override
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        DNode sortedList = null;
        DNode current = head;
        do {
            DNode nextNode = current.next;
            sortedList = insertIntoSortedList(sortedList, current);
            current = nextNode;
        } while (current != head);

        head = sortedList;
        tail = head;
        while (tail.next != null && tail.next != head) {
            tail = tail.next;
        }
        tail.next = head;
    }


    private DNode insertIntoSortedList(DNode sortedList, DNode node) {
        if (sortedList == null || sortedList.data >= node.data) {
            node.next = sortedList;
            sortedList = node;
        } else {
            DNode current = sortedList;
            while (current.next != null && current.next != sortedList && current.next.data < node.data) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
        return sortedList;
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
        do {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        } while (current != head);
        return true;
    }

    @Override
    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Unsorted" : "Sorted"));

        System.out.print("List content: ");
        if (head != null) {
            DNode current = head;
            for (int i = 0; i < size; i++) {
                System.out.print(current.data + (i < size - 1 ? " -> " : ""));
                current = current.next;
            }
            System.out.println();
        }
    }
}
        


