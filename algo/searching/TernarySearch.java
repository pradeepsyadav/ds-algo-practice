public class TernarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 ,5, 6 , 7 ,8, 9, 10 };
        int mid1 = 0, mid2 = 0, l, r = 0;
        int key = 9;

        l = 0;
        r = arr.length - 1;
        mid1 = l + (r - l) / 3;
        mid2 = r - (r - l) / 3;

        while (r>=l) {
            mid1 = l + (r - l) / 3;
            mid2 = r - (r - l) / 3;
            if(arr[mid1] == key) {System.out.println(mid1); return;}
            if(arr[mid2] == key) {System.out.println(mid2); return;}
            if (key < arr[mid1]) {
                r = mid1 - 1;
            } else if (key > arr[mid2]) {
                l = mid2 + 1;
                // r = mid2 - 1;
            } else {
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }

        System.out.println("not found");

    }
}
