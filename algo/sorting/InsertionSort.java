public class InsertionSort implements SortingAlgo {

    @Override
    /**
     * for every element find a place to "insert" in the already sorted group
     * worst: O(n^2), 
     * best: O(n) - every time it will not go inside while loop, since the list is already sorted.
     * average: O(n2)
     */
    public int[] sort(int[] ar) {

        for (int i = 1; i < ar.length; i++) {

            int key = ar[i];
            int j = i - 1;

            while (j >= 0 && ar[j] > key) {
                ar[j + 1] = ar[j];
                j--;
            }

            ar[j + 1] = key;
        }

        return ar;

    }

    public static void main(String[] args) {
        SortingAlgo insert = new InsertionSort();
        ArrayPrinter.print(insert.sort(data));
    }

}
