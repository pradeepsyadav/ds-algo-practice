import java.util.Arrays;

public class FractionalKnapSack {

    static class KnapItem {
        public int weight;
        public int value;
        public KnapItem(int value, int weight) {
            this.weight = weight;
            this.value = value;
        }
    }

    static double getMaxValue(KnapItem[] items, int capacity) {

        double maxvalue = 0.0;

        Arrays.<KnapItem>sort(items, 0, items.length, (KnapItem i1, KnapItem i2) -> {
            double valToWeight1 = (double)i1.value / i1.weight;
            double valToWeight2 = (double)i2.value / i2.weight;

            if(valToWeight1 < valToWeight2) return 1;
            else return -1;
        });

        for(KnapItem item: items) {
            if (item.weight <= capacity) {
                capacity = capacity - item.weight;
                maxvalue = maxvalue + item.value;
            } else {
                double vperw = (double)item.value / item.weight;
                maxvalue = maxvalue + (capacity * vperw);
                capacity = 0;
                break;
            }
        }

        return maxvalue;

    }

    public static void main(String[] args) {
        KnapItem[] items = { new KnapItem(60, 10), // 6
                            new KnapItem(100, 20), // 5
                            new KnapItem(120, 30) }; // 4

        final int capacity = 50;

        double max_val = getMaxValue(items, capacity);
        System.out.println("The max value is : " + max_val);

        //60 + 100 + 80 = 240
    }
}
