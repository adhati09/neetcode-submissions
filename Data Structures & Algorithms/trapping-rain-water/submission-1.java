class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length < 3){
            return 0;
        }

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int[] min = new int[height.length];

        int maxLeft = height[0];
        int maxRight = height[0];

        for(int i = 0; i < height.length; i++){
            if(i > 0){
                if(height[i] > maxLeft){
                    maxLeft = height[i];
                    left[i] = maxLeft;
                }else{
                    left[i] = maxLeft;
                }
            }else{
                maxLeft = height[0];
                left[i] = maxLeft;

            }
        }

        for(int j = height.length - 1; j >= 0; j--){
            if(j == height.length-1){
                maxRight = height[height.length - 1];
                right[j] = maxRight;
            }else{
                if(height[j] > maxRight){
                    maxRight = height[j];
                    right[j] = maxRight;
                }else{
                    right[j] = maxRight;
                }
            }
        }

        for(int k = 0; k < height.length; k++){
            min[k] = Math.min(left[k], right[k]);
        }

        int sum = 0;
        for(int s = 0; s < height.length; s++){
            int water = min[s] - height[s];
            if(water > 0){
                sum+=water;
            }
        }

        return sum;
    }
}
