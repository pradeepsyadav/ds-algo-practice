public class ArrayPrinter {
    static void print(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if(i==arr.length-1) System.out.print(arr[i] + "\n");
            else System.out.print(arr[i] + ", ");
        }
    }
}
