package weekone;

/**
 * Decided To Use Moore Voting Technique for solving.
 * */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            if (num == candidate) count++;
            else count--;
        }
        return candidate;
    }

    public static void main(String[] args) {

    }
}
