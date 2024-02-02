package weekfour;

import java.util.Stack;

public class DecodeStrings {

    public static String decodeString(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<StringBuilder> ss = new Stack<>();

        int n = s.length(), num = 0;
        StringBuilder str = new StringBuilder();

        for (char ch : s.toCharArray()) {
            // If number we need to count.
            if (ch >= '0' && ch <= '9') {
                num = (num * 10) + ch - '0';

            // If opening bracket store the previous string and number adn reset!
            } else if (ch == '[') {
                ss.push(str);
                str = new StringBuilder();
                is.push(num);
                num = 0;

            // If closing bracket, we need to take the current string and append it count times to top.
            } else if (ch == ']') {
                StringBuilder temp = str;
                str = ss.pop();
                int count = is.pop();

                while (count-- > 0) {
                    str.append(temp);
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}
