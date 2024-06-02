package cpclub.weekthree;

import java.util.LinkedList;

public class MaxScoreRemovingSubstrings {

    public int maximumGain(String s, int x, int y) {
        if (x >= y) return get(s, x, y, 'a', 'b');
        else return get(s, y, x, 'b', 'a');
    }

    private int get(String s, int x, int y, char ch1, char ch2) {
        int ans = 0;
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && (stack.peek() == ch1 && ch == ch2)) {
                stack.pop();
                ans += x;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) builder.append(stack.pop());
        s = builder.reverse().toString();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && (stack.peek() == ch2 && ch == ch1)) {
                stack.pop();
                ans += y;
            } else {
                stack.push(ch);
            }
        }
        return ans;
    }
}
