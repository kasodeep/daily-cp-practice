package cpclub.weekone;

import java.util.Arrays;

/**
 * Intuition was to sort the array by comparing the concatenation.
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) numStrings[i] = String.valueOf(nums[i]);

        Arrays.sort(numStrings, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        if (numStrings[0].equals("0")) return "0";
        StringBuilder result = new StringBuilder();

        for (String numString : numStrings) result.append(numString);
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
