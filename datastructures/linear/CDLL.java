package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {
    
    public CDLL() {
        super();
    }

    public CDLL(DNode head) {
        super(head);
        head.next = head;
        head.prev = head;
    }

    @Override
    public void insertHead(DNode node) {
        if (head == null) {
            node.next = node;
            node.prev = node;
            head = node;
            tail = node;
        } else {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            head = node;
        }
        size++;
    }

    @Override
    public void insertTail(DNode node) {
        if (tail == null) {
            insertHead(node);
        } else {
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
            tail = node;
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
            node.prev = current;
            current.next.prev = node;
            current.next = node;
            size++;
        }
    }

    @Override
    public void sortedInsert(DNode node) {
        if (!isSorted()) {
            sort();
        }
        if (head == null) {
            insertHead(node);
        } else if (head.data >= node.data) {
            insertHead(node);
        } else {
            DNode current = head;
            while (current.next != head && current.next.data < node.data) {
                current = current.next;
            }
            node.next = current.next;
            node.prev = current;
            current.next.prev = node;
            current.next = node;
            if (current == tail) {
                tail = node;
            }
            size++;
        }
    }

    @Override
    public DNode search(int data) {
        DNode current = head;
        if (current == null) {
            return null;
        }
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
                head.prev = tail;
                tail.next = head;
            }

            size--;
        }
    }

    @Override
    public void deleteTail() {
        if (tail != null) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
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
        if (current.next.data == data){
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
    public void sort() {
        if (head == null || head.next == head) {
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
        tail = sortedList.prev;
        tail.next = head;
        head.prev = tail;
    }

    private DNode insertIntoSortedList(DNode sortedList, DNode node) {
        if (sortedList == null) {
            node.prev = node;
            node.next = node;
            return node;
        } else if (sortedList.data >= node.data) {
            node.next = sortedList;
            node.prev = sortedList.prev;
            sortedList.prev.next = node;
            sortedList.prev = node;
            return node;
        } else {
            DNode current = sortedList;
            while (current.next != sortedList && current.next.data < node.data) {
                current = current.next;
            }
            node.next = current.next;
            node.prev = current;
            current.next.prev = node;
            current.next = node;
            return sortedList;
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
        if (head == null || head.next == head) {
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
            do {
                System.out.print(current.data + (current.next != head ? " <-> " : ""));
                current = current.next;
            } while (current != head);
        }
        System.out.println();
    }
}

