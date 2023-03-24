package ll;

public class LinkedList {

    private Node head;
    private Node tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    public void insertLast(int value) {
        if (head == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
    }

    public void display() {
        Node temp = head;
        System.out.print("head" + " --> ");
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("tail");
    }

    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // sorting
    // bubblesort
    public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    sorted = false;
                }
                current = current.next;
            }
        }
    }

    public void B() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    sorted = false;
                }
                current = current.next;
            }
        }

    }

    // selection sort
    public void selectionSort() {

        Node temp = head;
        while (temp != null) {
            Node Min = findMinNode(temp);
            swapNodeValues(Min, temp);
            temp = temp.next;
        }
    }

    private void swapNodeValues(Node min, Node temp) {
        int value = temp.data;
        temp.data = min.data;
        min.data = value;
    }

    private Node findMinNode(Node temp) {
        int minData = temp.data;
        Node minNode = temp;
        while (temp.next != null) {
            if (minData > temp.next.data) {
                minData = temp.next.data;
                minNode = temp.next;
            }
            temp = temp.next;
        }
        return minNode;
    }

    // insertion sort
    public void insertionSort() {

        if (head == null || head.next == null) {
            return;
        }

        Node sorted = null;
        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;
            if (sorted == null || temp.data < sorted.data) {
                temp.next = sorted;
                sorted = temp;
            } else {
                Node search = sorted;
                while (search.next != null && temp.data > search.next.data) {
                    search = search.next;
                }
                temp.next = search.next;
                search.next = temp;
            }
            temp = nextNode;
        }
        head = sorted;
    }

    // insertion sort
    public void insert() {
        if (head == null || head.next == null) {
            return;
        }

        Node temp = head;
        Node sort = null;

        while (temp != null) {
            Node nextN = temp.next;
            if (sort == null || temp.data < sort.data) {
                temp.next = sort;
                sort = temp;
            } else {
                Node search = sort;
                while (search.next != null && temp.data > search.next.data) {
                    search = search.next;
                }
                temp.next = search.next;
                search.next = temp;
            }
            temp = nextN;
        }
        head = sort;
    }

    // merge sort

    public void mergeSort() {
        head = mergeS(head);
    }

    public Node mergeS(Node temp) {
        if (temp == null || temp.next == null) {
            return temp;
        }
        Node slow = temp;
        Node fast = temp.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node mid = slow.next;
        slow.next = null;

        // recursive
        Node left = mergeS(temp);
        Node right = mergeS(mid);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;// i++
            } else {
                current.next = right;
                right = right.next;// j++
            }
            current = current.next;// k++
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }
        return dummy.next;
    }

    // quick sort
    public void quickSort() {
        quickS(head, tail);
    }

    Node partitionLast(Node start, Node end) {
        if (start == end || start == null || end == null) {
            return start;
        }
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;

        // Iterate till pen-ultimate node, since the last node is the PIVOT
        while (start != end) {
            if (start.data < pivot) {
                // pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        // swap whichever is following suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;

        return pivot_prev;
    }

    void quickS(Node start, Node end) {
        if (start == null || start == end || start == end.next)
            return;

        // split list and partition recurse

        Node pivot_prev = partitionLast(start, end);
        quickS(start, pivot_prev);

        // If PIVOT = START, we pick from next of PIVOT.

        if (pivot_prev != null && pivot_prev == start)
            quickS(pivot_prev.next, end);

        // If PIVOT is still in between the list, start from next to pivot since we have
        // pivot_prev, so we move two nodes.
        else if (pivot_prev != null && pivot_prev.next != null)
                quickS(pivot_prev.next.next, end);
    }

}
