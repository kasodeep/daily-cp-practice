package cpclub.weekthree;

import java.util.Stack;

public class LargestAreaHistogram {

    public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max_area = arr[0];

        int[] left_smaller = new int[n];
        int[] right_smaller = new int[n];
        for (int i = 0; i < n; i++) {
            left_smaller[i] = -1;
            right_smaller[i] = n;
        }

        int i = 0;
        while (i < n) {
            while (!s.empty() && s.peek() != -1 && arr[i] < arr[s.peek()]) {
                right_smaller[s.peek()] = i;
                s.pop();
            }

            left_smaller[i] = s.peek();
            s.push(i);
            i++;
        }

        for (i = 0; i < n; i++) {
            max_area = Math.max(max_area, arr[i] * (right_smaller[i] - left_smaller[i] - 1));
        }
        return max_area;
    }
}
