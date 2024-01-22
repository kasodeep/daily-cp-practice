package weekthree;

import java.util.Stack;

public class SumOfSubArrayMinimums {

    static int MOD = (int) 1e9 + 7;

    public static int sumSubArrayMin(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        s.push(-1);

        int[] left_smaller = new int[n];
        int[] right_smaller = new int[n];

        for (int i = 0; i < n; i++) {
            left_smaller[i] = -1;
            right_smaller[i] = n;
        }

        int i = 0;
        // Crazy Trick.
        while (i < n) {
            while (!s.empty() && s.peek() != -1 && arr[i] < arr[s.peek()]) {
                right_smaller[s.peek()] = i;
                s.pop();
            }
            left_smaller[i] = s.peek();
            s.push(i);
            i++;
        }

        long answer = 0;
        for (i = 0; i < n; ++i) {
            long count = (long) (i - left_smaller[i]) * (right_smaller[i] - i) % MOD;
            answer += (count * arr[i]) % MOD;
            answer %= MOD;
        }

        return (int) answer;
    }
}
