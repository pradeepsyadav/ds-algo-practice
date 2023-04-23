public class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode(int x) {
        this.data = x;
        this.next = null;
        this.prev = null;
    }

    DoublyNode() {
        this.next = null;
        this.prev = null;
    }
}
