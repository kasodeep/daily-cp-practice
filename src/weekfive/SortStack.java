package weekfive;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sort(Stack<Integer> s) {
        if (s.isEmpty()) return s;

        int x = s.pop();
        sort(s);

        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty() && s.peek() > x) temp.push(s.pop());

        s.push(x);
        while (temp.size() > 0) s.push(temp.pop());
        return s;
    }
}
