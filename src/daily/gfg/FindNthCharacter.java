package daily.gfg;

public class FindNthCharacter {

    public static char nthCharacter(String s, int r, int n) {
        StringBuilder ans = new StringBuilder();
        while (r-- > 0) {
            int i = 0;
            int N = s.length();
            while (i < N) {
                if (s.charAt(i) == '1') ans.append("10");
                else ans.append("01");
                i++;

                if (ans.length() > n) break;
            }
            s = ans.toString();
            ans = new StringBuilder();
        }
        return s.charAt(n);
    }
}
