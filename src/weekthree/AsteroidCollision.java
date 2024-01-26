package weekthree;

import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> s = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0 || s.isEmpty()) {
                s.push(asteroid);
            } else {
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroid)) {
                    s.pop();
                }

                if (!s.isEmpty() && s.peek() == Math.abs(asteroid)) {
                    s.pop();
                } else {
                    if (s.isEmpty() || s.peek() < 0) s.push(asteroid);
                }
            }
        }

        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) res[i] = s.pop();
        return res;
    }
}


