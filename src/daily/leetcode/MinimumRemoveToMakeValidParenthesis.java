package daily.leetcode;

public class MinimumRemoveToMakeValidParenthesis {

    public static String minRemoveToMakeValid(String s) {
        int open = 0, close = 0;
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                open++;
            } else if (ch[i] == ')') {
                close++;
                if (close > open) {
                    close--;
                    ch[i] = '0';
                }
            }
        }

        open = 0;
        close = 0;
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] == ')') {
                close++;
            } else if (ch[i] == '(') {
                open++;
                if (open > close) {
                    open--;
                    ch[i] = '0';
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char cha : ch) {
            if (cha != '0') ans.append(cha);
        }
        return ans.toString();
    }
}
