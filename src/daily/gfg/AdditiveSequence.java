package daily.gfg;

public class AdditiveSequence {

    public static boolean isAdditiveSequence(String n) {
        char[] arr = n.toCharArray();

        // The logic was in this two loops.
        for (int i = 1; i < 10 && i <= n.length() / 2; i++) {
            for (int j = 1; j < 10 && j <= n.length() / 2; j++) {
                int num1 = getNumber(arr, i, 0);
                int num2 = getNumber(arr, j, i);
                if (check(num1, num2, i + j, arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int getNumber(char[] arr, int len, int start) {
        int i = 0, ans = 0, pow = 0;
        while (i < len && i + start < arr.length) {
            ans = 10 * ans + (arr[start + i] - '0');
            i++;
        }
        return ans;
    }

    static boolean check(int num1, int num2, int index, char[] arr) {
        if (index >= arr.length) {
            return false;
        }

        while (index < arr.length) {
            int curr = num1 + num2;
            int curr_val = arr[index] - '0';
            index++;
            while (curr_val < curr && index < arr.length) {
                curr_val = 10 * curr_val + (arr[index] - '0');
                index++;
            }
            if (curr_val != curr) {
                return false;
            } else {
                num1 = num2;
                num2 = curr;
            }
        }
        return true;
    }
}
