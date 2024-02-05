package weekfive;

public class CircularTour {

    static int tour(int[] petrol, int[] distance) {
        int start = 0;
        int end = 1;

        int n = petrol.length;
        int curr_petrol = petrol[start] - distance[start];

        while (end != start || curr_petrol < 0) {

            // We need a new starting point!
            while (curr_petrol < 0 && start != end) {
                curr_petrol -= petrol[start] - distance[start];
                start = (start + 1) % n;
                if (start == 0) return -1;
            }
            curr_petrol += petrol[end] - distance[end];
            end = (end + 1) % n;
        }
        return start;
    }
}
