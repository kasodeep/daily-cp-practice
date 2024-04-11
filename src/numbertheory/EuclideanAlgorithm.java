package numbertheory;

/**
 * This class calculates the gcd of a and b in O(log(min(a, b))) time.
 * */
public class EuclideanAlgorithm {

    // Recursive
    public static int gcdRecur(int a, int b) {
        return b != 0 ? gcdRecur(b, a % b) : a;
    }

    // Iterative
    int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
