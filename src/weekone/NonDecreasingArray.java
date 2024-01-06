package weekone;

public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        boolean ans = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (ans) {
                    return false;
                } else {
                    ans = true;
                    if (i != 1) {
                        if (nums[i] < nums[i - 2]) nums[i] = nums[i - 1];
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
