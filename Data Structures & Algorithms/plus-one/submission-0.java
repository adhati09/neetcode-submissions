class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        int[] newarr = new int[digits.length + 1];
        newarr[0] = 1;
        for(int j = 1; j < newarr.length; j++){
            newarr[j] = digits[j-1];
        }

        return newarr;
    }
}
