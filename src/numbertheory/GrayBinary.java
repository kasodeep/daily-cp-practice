package numbertheory;

public class GrayBinary {

    // Gray to Binary!
    public static int binaryConverter(int n) {
        int res = n;

        while (n > 0) {
            n >>= 1;
            res ^= n;
        }
        return res;
    }

    // Binary to Gray!
    public static int grayConverter(int n) {
        return n ^ (n >> 1);
    }
}
