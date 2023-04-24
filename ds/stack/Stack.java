public class Stack {

    final int MAX_SIZE = 1;
    final int[] stack = new int[MAX_SIZE];
    int top = -1;

    void push(int data) {
        top++;
        if (top == MAX_SIZE)
            throw new RuntimeException("Stack Overflow !!");

        stack[top] = data;

    }

    int pop() {
        if (top == -1)
        throw new RuntimeException("Stack Underflow !!");
        return stack[top--];
    }

    int peek() {
        return stack[top];
    }

    @Override
    public String toString() {
        String res = "";
        String delim = ", ";

        for (int i = 0; i <= top; i++) {
            delim = (i==top) ? "" : delim;
            res += (stack[i] + delim);
        }
        return res;
    }

    void print() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(9);
        // st.push(8);

        st.print();

        st.pop();
        st.print();
        st.pop();


    }
}
