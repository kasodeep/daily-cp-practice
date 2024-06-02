package cpclub.weekthree;

import java.util.Scanner;
import java.util.Stack;

public class AlternatingCurrent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        System.out.println(st.size() == 0 ? "Yes" : "No");
    }
}
