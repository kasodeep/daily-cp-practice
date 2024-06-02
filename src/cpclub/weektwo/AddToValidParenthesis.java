package cpclub.weektwo;

public class AddToValidParenthesis {

    public static int minAddToMakeValid(String s) {
        int minMoves = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;

            if (count < 0) {
                minMoves++;
                count = 0;
            }
        }

        minMoves = minMoves + count;
        return minMoves;
    }
}
