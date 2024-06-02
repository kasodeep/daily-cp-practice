package cpclub.weekthree;

import java.util.List;
import java.util.Stack;

public class BeautifulTowersI {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Stack<Integer> s = new Stack<>();
        int n = maxHeights.size();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = maxHeights.get(i);
        s.push(-1);

        int[] left_smaller = new int[n];
        int[] right_smaller = new int[n];

        for (int i = 0; i < n; i++) {
            left_smaller[i] = -1;
            right_smaller[i] = n;
        }

        int i = 0;
        while (i < n) {
            while (!s.empty() && s.peek() != -1 && arr[i] <= arr[s.peek()]) {
                right_smaller[s.peek()] = i;
                s.pop();
            }
            left_smaller[i] = s.peek();
            s.push(i);
            i++;
        }

        long answer = 0;
        for (int j = 0; j < n; j++) {
            long temp = 0;
            for (i = j; i < n; ) {
                temp += (right_smaller[i] - i) * (long) arr[i];
                i = right_smaller[i];
            }

            for (i = j - 1; i >= 0; ) {
                temp += (i - left_smaller[i]) * (long) arr[i];
                i = left_smaller[i];
            }

            answer = Math.max(answer, temp);
        }
        return answer;
    }
}
