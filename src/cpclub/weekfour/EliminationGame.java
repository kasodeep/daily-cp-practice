package cpclub.weekfour;

public class EliminationGame {

    public static int lastRemaining(int n) {
        if (n == 1) return 1;
        return 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
}
