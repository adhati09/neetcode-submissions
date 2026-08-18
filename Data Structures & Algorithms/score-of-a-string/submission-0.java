class Solution {
    public int scoreOfString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        String temp = "abcdefghijklmnopqrstuvwxyz";
        int count = 97;
        for(int i = 0; i < temp.length(); i++){
            map.put(temp.charAt(i), count);
            count++;
        }

        int sum = 0;
        for(int j = s.length() - 1; j > 0; j--){
            sum+= Math.abs(map.get(s.charAt(j)) - map.get(s.charAt(j - 1)));
        }

        return sum;


    }
}