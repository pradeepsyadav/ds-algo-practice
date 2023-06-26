public class SelectionSort implements SortingAlgo {

    /**
     * find either the min or max to put after the already sorted group.
     * worst: O(n2), best()
     */
    @Override
    public int[] sort(int[] ar) {

        final int len = ar.length;
        int temp;

        for (int ptr = 0; ptr < len - 1; ptr++) {
            int minInd = findMinElem(ar, ptr, len - 1);
            temp = ar[ptr];
            ar[ptr] = ar[minInd];
            ar[minInd] = temp;
        }

        return ar;
    }

    private int findMinElem(int[] ar, int start, int end) {

        int min = ar[start];
        int index = start;

        for (int i = start; i <= end; i++) {
            if (ar[i] < min) {
                min = ar[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        SortingAlgo selectionSort = new SelectionSort();
        ArrayPrinter.print(selectionSort.sort(data));
    }

}
