public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {56, 22, 34, 109, 45, 32, 21};
        int key = 45;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == key) {
                System.out.println(" Key found at: " + (i+1));
                break;
            }
        }
    }
}
