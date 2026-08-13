class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxVol = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(heights[left], heights[right]);
            int vol = width * minHeight;
            maxVol = Math.max(maxVol, vol);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxVol;
    }
}
