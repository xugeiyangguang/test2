package HomeWork;

public class LargestRectangleArea {
    public static void main(String[] args) {

    }
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        if (height.length == 1) {
            return height[0];
        }

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int count = 1;
            for (int left = i - 1; left >= 0 && height[left] >= height[i]; left--) {
                count++;
            }
            for (int right = i + 1; right < height.length && height[right] >= height[i]; right++) {
                count++;
            }
            max = Math.max(max, count * height[i]);
        }
        return max;
    }
}
