package weekthree;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length - 1;

        int water = 0;
        if (height.length == 0) return 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
