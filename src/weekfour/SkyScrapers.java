package weekfour;

import java.util.*;

public class SkyScrapers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Stack<Integer> s = new Stack<>();
        s.push(-1);

        int[] left_smaller = new int[n];
        int[] right_smaller = new int[n];
        Arrays.fill(left_smaller, -1);
        Arrays.fill(right_smaller, n);

        for (int i = 0; i < n; i++) {
            while (!s.empty() && s.peek() != -1 && arr[i] <= arr[s.peek()]) {
                right_smaller[s.peek()] = i;
                s.pop();
            }
            if (!s.empty()) {
                left_smaller[i] = s.peek();
            }
            s.push(i);
        }

        long answer = 0;
        int bestIndex = -1;

        for (int j = 0; j < n; j++) {
            long temp = 0;

            for (int i = j - 1; i >= 0; i = left_smaller[i]) {
                temp += (long) (i - left_smaller[i]) * arr[i];
            }

            for (int i = j; i < n; i = right_smaller[i]) {
                temp += (long) (right_smaller[i] - i) * arr[i];
            }

            if (answer < temp) {
                answer = temp;
                bestIndex = j;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = bestIndex - 1; i >= 0; i = left_smaller[i]) {
            ans.addAll(0, Collections.nCopies(i - left_smaller[i], arr[i]));
        }

        for (int i = bestIndex; i < n; i = right_smaller[i]) {
            ans.addAll(Collections.nCopies(right_smaller[i] - i, arr[i]));
        }

        for (int num : ans) System.out.print(num + " ");
    }
}
