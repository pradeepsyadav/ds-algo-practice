class SinglyLinkedList {
    Node head;

    // Insertions
    // at beginning: time complexity: O(1)
    void insertAtBeginning(int x) {
        Node node = new Node(x);
        node.next = head;
        this.head = node;
    }

    // at end: time complexity: O(n) where n is number of nodes
    void insertAtEnd(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
            return;
        }
        Node curr = this.head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    // at position: time complexity: O(1) since Node is already given
    void insertAfter(Node n, int data) {
        Node node = new Node(data);

        if(n.next == null) {
            n.next = node;
            return;
        }
        node.next = n.next;
        n.next = node;
    }

    // Deletions
    // from beginning: Time complexity O(1)
    void deleteAtBeginning() {
        if(this.head != null)
            this.head = this.head.next;
    }

    // from end: Time complexity O(n)
    void deleteFromEnd() {
        Node currNode = head;
        Node prev = null;

        while (currNode.next != null) {
            prev = currNode;
            currNode = currNode.next;
        }
        prev.next = null;
    }

    // delete at some position: Time complexity O(n)
    public void deleteAtPosition(int pos) {
        if(head == null || pos == 0) return;

        if (pos == 1) {
            head = head.next;
            return;
        }
        int currPos = 1;
        Node currNode = head;
        Node prev = currNode;

        while (currPos < pos && currNode.next != null) {
            prev = currNode;
            currNode = currNode.next;
            currPos++;
        }
        if(currNode.next == null) return;

        prev.next = currNode.next;

    }

    public void addAll(int ... numbers) {
        for (int i=0; i<numbers.length; i++) {
            insertAtEnd(numbers[i]);
        }
    }

    public void addAll(Node ... nodes) {
        this.head = nodes[0];
        for (int i=0; i<nodes.length - 1; i++) {
            nodes[i].next = nodes[i+1];
        }
    }

    public void printList() {
        System.out.println(this);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node curr = this.head;
        while(curr.next != null) {
            sb.append(curr.data + ",");
            curr = curr.next;
        }
        sb.append(curr.data + "]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.addAll(1, 2, 3, 4, 5, 6);
        System.out.println(sl);

        sl.insertAtEnd(22);
        System.out.println(sl);

        sl.insertAtBeginning(59);
        System.out.println(sl);

        System.out.println("New list created..");
        sl = new SinglyLinkedList();
        Node toinsertAfter = new Node(4);
        sl.addAll(new Node(1), new Node(2), new Node(3), toinsertAfter, new Node(5), new Node(6));
        System.out.println(sl);

        sl.insertAfter(toinsertAfter, 89);
        System.out.println(sl);

        sl.deleteAtBeginning();
        sl.printList();

        sl.deleteFromEnd();
        sl.printList();

        sl.deleteAtPosition(4);
        sl.printList();

        sl.deleteAtPosition(1);
        sl.printList();

        sl.deleteAtPosition(4);
        sl.printList();

        sl.deleteAtPosition(2);
        sl.printList();

        sl.deleteAtPosition(-1);
        sl.printList();
    }
}