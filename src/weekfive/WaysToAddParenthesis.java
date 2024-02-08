package weekfive;

import java.util.ArrayList;
import java.util.List;

public class WaysToAddParenthesis {

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                String lStr = expression.substring(0, i);
                String rStr = expression.substring(i + 1);

                List<Integer> leftRes = diffWaysToCompute(lStr);
                List<Integer> rightRes = diffWaysToCompute(rStr);

                for (Integer l : leftRes) {
                    for (Integer r : rightRes) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(expression));
        return res;
    }
}
