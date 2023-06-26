public class MergeSort implements SortingAlgo {

    /**
     * worst: O(nlogn) = best = average
     * useful for external sort when it cant fit into memory.
     */
    @Override
    public int[] sort(int[] ar) {
        return sort(ar, 0, ar.length-1);
    }

    private void merge(int[] ar, int start, int end, int mid) {  //0, 1, 0
        int left_size = mid - start + 1;
        int right_size = end - mid;

        int[] left_temp = new int[left_size];
        int[] right_temp = new int[right_size];

        for (int i = 0; i < left_temp.length; i++) {
            left_temp[i] = ar[start+i];
        }

        for (int i = 0; i < right_temp.length; i++) {
            right_temp[i] = ar[mid+1+i];
        }

        int left_ptr =0, right_ptr =0, merged_ptr=start;

        while(left_ptr < left_size && right_ptr < right_size) {
            if(left_temp[left_ptr] <= right_temp[right_ptr]) {
                ar[merged_ptr] = left_temp[left_ptr];
               left_ptr++; 
            }   
            else {
                ar[merged_ptr] = right_temp[right_ptr];
                right_ptr++;
            }
            merged_ptr++;
        }

        while(left_ptr<left_size) {
            ar[merged_ptr] = left_temp[left_ptr];
            left_ptr++;
            merged_ptr++;
        }
        while(right_ptr<right_size) {
            ar[merged_ptr] = right_temp[right_ptr];
            right_ptr++;
            merged_ptr++;
        }
    }

    private int[] sort(int[] ar, int start, int end) {

        if (start < end) {

            int mid = start + (end - start) / 2;

            sort(ar, start, mid);
            sort(ar, mid + 1, end);

            merge(ar, start, end, mid);

            return ar;
        }
        return ar;
    }

    public static void main(String[] args) {
        SortingAlgo mergesort = new MergeSort();
        ArrayPrinter.print(mergesort.sort(data));
    }

}
