package daily.gfg;

import java.util.Stack;

public class RemoveKDigits {

    public static String removeKDigits(String S, int K) {
        if (S.length() == K) return "0";

        Stack<Character> q = new Stack<>();
        q.push(S.charAt(0));

        for (int i = 1; i < S.length(); i++) {
            while (!q.isEmpty() && q.peek() > S.charAt(i) && K != 0) {
                q.pop();
                K--;
            }
            q.push(S.charAt(i));
        }

        Stack<Character> q2 = new Stack<>();
        while (!q.isEmpty()) {
            while (K != 0) {
                q.pop();
                K--;
            }
            q2.push(q.pop());
        }

        // Handling Zeros.
        while (q2.size() != 1 && q2.peek() == '0') q2.pop();
        StringBuilder sb = new StringBuilder();

        while (!q2.isEmpty()) sb.append(q2.pop());
        return sb.toString();
    }
}
