public class DoublyLinkedList {
    DoublyNode head;

    // Insertions
    // at beginning: time complexity: O(1)
    void insertAtBeginning(int x) {
        DoublyNode node = new DoublyNode(x);
        node.next = head;
        node.prev = null;
        if(head != null)
            head.prev = node;
        this.head = node;
    }

    // at end: time complexity: O(n) where n is number of nodes
    void insertAtEnd(int data) {
        DoublyNode node = new DoublyNode(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        DoublyNode curr = this.head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        node.prev = curr;
    }

    // after some node: time complexity: O(1)
    void insertAfter(DoublyNode node, int data) {
        DoublyNode newnode = new DoublyNode(data);
        newnode.next = node.next;
        newnode.prev = node;
        node.next = newnode;
    }

    // Deletions
    // from beginning: Time complexity O(1)
    void deleteAtBeginning() {
        if(this.head != null) {
            this.head = this.head.next;
            head.prev = null;
        }
    }

    // from end: Time complexity O(n)
    void deleteFromEnd() {
        DoublyNode currNode = head;
        
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        (currNode.prev).next = null;
    }


    // delete at some position: Time complexity O(n)
    public void deleteAtPosition(int pos) {
        if(head == null || pos == 0) return;

        if (pos == 1) {
            deleteAtBeginning();
            return;
        }
        int currPos = 1;
        DoublyNode currNode = head;

        while (currPos < pos && currNode.next != null) {
            currNode = currNode.next;
            currPos++;
        }
        if(currNode.next == null) return;

        (currNode.prev).next = currNode.next;
        (currNode.next).prev = currNode.prev;
    }

    public void addAll(int ... numbers) {
        for (int i=0; i<numbers.length; i++) {
            insertAtBeginning(numbers[i]);
        }
    }

    public void addAll(DoublyNode... nodes) {

        this.head = nodes[0];

        for (int i = 0; i < nodes.length; i++) {

            if (i != nodes.length - 1)
                nodes[i].next = nodes[i + 1];

            if (i != 0)
                nodes[i].prev = nodes[i - 1];
        }

    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        DoublyNode curr = this.head;
        while(curr.next != null) {
            sb.append(curr.data + ",");
            curr = curr.next;
        }
        sb.append(curr.data + "]");
        return sb.toString();
    }

    public void printList() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addAll(1, 2, 3 ,4 ,5, 6, 7);
        dll.printList();

        dll.insertAtEnd(34);
        dll.printList();

        System.out.println("New list created");
        DoublyNode nodeToINsertAfter = new DoublyNode(23);
        dll.addAll(new DoublyNode(11),
                new DoublyNode(12),
                new DoublyNode(13),
                nodeToINsertAfter,
                new DoublyNode(14),
                new DoublyNode(15),
                new DoublyNode(16));
        dll.printList();

        dll.insertAfter(nodeToINsertAfter, 99);
        dll.printList();

        dll.deleteAtBeginning();
        dll.printList();

        dll.deleteFromEnd();
        dll.printList();

        dll.deleteAtPosition(4);
        dll.printList();
    }
}
