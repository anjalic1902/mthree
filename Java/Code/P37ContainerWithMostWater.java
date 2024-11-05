public class P37ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the area formed by the left and right lines
            int area = Math.min(height[left], height[right]) * (right - left);
            // Update the maximum area found
            maxArea = Math.max(maxArea, area);

            // Move the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum water area is: " + maxArea(height));  // Output: 49
    }
}
