package weekthree;

import java.util.Scanner;
import java.util.Stack;

public class CompilersParsers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            String s = sc.next();
            Stack<Character> st = new Stack<>();

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '<') st.push('<');
                else {
                    if (st.isEmpty()) {
                        break;
                    } else {
                        st.pop();
                        if (st.isEmpty()) count = i + 1;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
