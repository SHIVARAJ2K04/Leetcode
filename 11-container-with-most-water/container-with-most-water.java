class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxA = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int area = h * (j - i);
            if (area > maxA) maxA = area;
            if (height[i] < height[j]) i++;
            else j--;
        }
        return maxA;
    }
}
