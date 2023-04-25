class SimpleQueue {

    private final int MAX_ELE = 5;
    private int[] queue = new int[MAX_ELE];
    private int front = 0;
    private int rear = -1;

    public void enqueue(int d) { // this always happens from rear
        rear++;
        if(rear > MAX_ELE - 1)
            throw new RuntimeException("Queue Full !!");
        queue[rear] = d;
    }

    public int dequeue() {
        if(front == MAX_ELE || front > rear) {
            throw new RuntimeException("Item cannot be removed after queue end!!");
        }
        
        return queue[front++];
    }

    public static void main(String[] args) {
        SimpleQueue sq = new SimpleQueue();
        sq.enqueue(1);
        sq.enqueue(2);
        sq.enqueue(3);
        sq.enqueue(4);
        sq.enqueue(5);
        sq.enqueue(5);
        sq.dequeue();
        sq.dequeue();
        System.out.println("x");
    }
}