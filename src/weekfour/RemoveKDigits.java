package weekfour;

import java.util.Stack;

public class RemoveKDigits {

    public static String removeKDigits(String num, int k) {
        if (k == num.length()) return "0";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k != 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while (k != 0) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while (st.size() > 0) ans.append(st.pop());
        ans.reverse();

        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') i++;
        return i == ans.length() ? "0" : ans.substring(i);
    }
}
