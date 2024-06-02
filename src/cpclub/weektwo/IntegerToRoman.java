package cpclub.weektwo;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        int[] arr = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] sym = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        int i = arr.length - 1;
        StringBuilder roman = new StringBuilder();
        while (num > 0) {
            while (num >= arr[i]) {
                roman.append(sym[i]);
                num = num - arr[i];
            }
            i--;
        }
        return roman.toString();
    }
}
