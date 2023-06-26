/**
 * ]
 * The hihest element gets bubbled up in each pass
 */
class BubbleSort implements SortingAlgo{

    /**
     * time complexity: worst: O(n^2), best: O(n^2), average: O(n^2) 
     * @param arr
     */
    public int[] sort(int[] arr) {
        int temp;
        for (int pass = arr.length - 1; pass > 0; pass--) {
            for (int j = 0; j <= pass - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SortingAlgo bubble = new BubbleSort();
        ArrayPrinter.print(bubble.sort(SortingAlgo.data));
    }
}