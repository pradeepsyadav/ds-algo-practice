public class QuickSort implements SortingAlgo {

    /**
     * worst: O(n2) since most unbalanced pivot when its either the smallest or largest
     * best: O (n logn)
     */
    @Override
    public int[] sort(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
        return ar;
    }

    void quickSort(int[] ar, int start, int end) {
        if (start < end) {
            int piv = partition(ar, start, end);
            quickSort(ar, start, piv - 1); // dividing left half before pivot
            quickSort(ar, piv + 1, end); // dividing right half after pivot
        }
    }

    int partition(int[] ar, int start, int end) {
        int pivot_value = ar[end];
        int pivot_placement = start - 1;

        for (int i = start; i < end; i++) { // bring all smaller elements than pivot, to the start of the array.

            if (ar[i] < pivot_value) {
                pivot_placement++;
                swap(ar, pivot_placement, i);
            }
        }
        swap(ar, end, pivot_placement + 1);
        return pivot_placement + 1;
    }

    void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort qsort = new QuickSort();
        try {
            
            int[] ar = qsort.sort(data);
            ArrayPrinter.print(ar);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
