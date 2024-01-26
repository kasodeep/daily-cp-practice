package daily.gfg;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr, new ItemComparator());
        double profit = 0;

        for (int i = 0; i < n && W > 0; i++) {
            Item item = arr[i];
            if (item.weight <= W) {
                profit += item.value;
                W -= item.weight;
            } else {
                profit += (double) item.value / item.weight * W;
                W = 0;
            }
        }

        return profit;
    }

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    private static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare((double) o2.value / o2.weight, (double) o1.value / o1.weight);
        }
    }
}
