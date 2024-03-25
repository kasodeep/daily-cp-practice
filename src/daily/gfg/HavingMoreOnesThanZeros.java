package daily.gfg;

import java.util.ArrayList;

public class HavingMoreOnesThanZeros {

    static ArrayList<String> NBitBinary(int N) {
        ArrayList<String> list = new ArrayList<>();
        solve(N, 0, 0, "", list);
        return list;
    }

    public static void solve(int N, int ones, int zeros, String temp, ArrayList<String> list) {
        if (N == 0) {
            list.add(temp);
            return;
        }

        solve(N - 1, ones + 1, zeros, temp + '1', list);
        if (zeros + 1 <= ones) solve(N - 1, ones, zeros + 1, temp + '0', list);
    }
}
