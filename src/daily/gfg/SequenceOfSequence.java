package daily.gfg;

public class SequenceOfSequence {

    static int numberSequence(int m, int n) {
        return solve(m, n);
    }

    static int solve(int m, int n) {
        if (n > m) return 0;
        if (n == 0) return 1;
        return solve(m / 2, n - 1) + solve(m - 1, n);
    }
}
