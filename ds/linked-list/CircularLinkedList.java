public class CircularLinkedList {
    Node lastNode;

    // Insertions
    // at empty list: time complexity: O(1)
    void insertInEmpty(int x) {
        Node node = new Node(x);

        if(lastNode!=null) return;
        node.next = node;
        lastNode = node;

    }

    // at beginning: time complexity: O(1)
    void insertAtBeginning(int x) {
        Node node = new Node(x);

        if(lastNode==null) {
            insertInEmpty(x);
            return;
        }

        node.next = lastNode.next;
        lastNode.next = node;

    }

    // at end: time complexity: O(1)
    void insertAtEnd(int x) {
        Node node = new Node(x);

        if(lastNode==null) {
            insertInEmpty(x);
            return;
        }
        node.next = lastNode.next;
        lastNode.next = node;
        lastNode = node;
    }

    // in between : time complexity O(n)
    void insertAfter(int toInsertAfter, int data) {

        if (lastNode == null)
            return;

        Node currNode = lastNode.next;
        do {
            currNode = currNode.next;
        } while (currNode.data != toInsertAfter && currNode != lastNode.next);

        if (currNode == lastNode.next)
            return; // node not found, and we are back to start.

        Node node = new Node(data);
        node.next = currNode.next;
        currNode.next = node;
    }

    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
        ll.insertInEmpty(22);

        ll.insertAtBeginning(100);
        ll.insertAtBeginning(45);

        ll.insertAtEnd(99);

        ll.insertAfter(100, 101);
        System.out.println("inserted");
    }
}
