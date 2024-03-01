package daily.leetcode;

public class MaximumOddBinary {

    public static String maximumOddBinaryNumber(String s) {
        int count1 = 0;
        int count0 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') count1++;
            else count0++;
        }

        StringBuilder result = new StringBuilder();
        result.append("1".repeat(Math.max(0, count1 - 1)));
        result.append("0".repeat(Math.max(0, count0)));
        result.append('1');

        return result.toString();
    }
}
