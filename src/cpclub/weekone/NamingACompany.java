package cpclub.weekone;

import java.util.HashSet;
import java.util.Set;

public class NamingACompany {

    public static long distinctNames(String[] ideas) {
        @SuppressWarnings("unchecked")
        Set<String>[] sets = new Set[26];

        for (int i = 0; i < 26; i++) sets[i] = new HashSet<>();
        for (String s : ideas) sets[s.charAt(0) - 'a'].add(s.substring(1));

        int[][] same = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (String s : sets[i]) {
                for (int j = i + 1; j < 26; j++) {
                    if (sets[j].contains(s)) {
                        same[i][j]++;
                    }
                }
            }
        }

        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                res += (long) (sets[i].size() - same[i][j]) * (sets[j].size() - same[i][j]) * 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
