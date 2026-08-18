class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int counter = 1;
        String temp = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < temp.length(); i++){
            map.put(temp.charAt(i), counter);
            counter++;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Base case: reaching the very end of the string represents 1 valid decoding path completed
        dp[n] = 1;

        // Process the string backwards from right to left
        for (int i = n - 1; i >= 0; i--) {
            // A zero cannot start a single digit or a double digit decoding group
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // Choice 1: Assume it is a single digit (always valid if it's not '0')
            dp[i] = dp[i + 1];

            // Choice 2: Try to pair it with the next digit to see if it makes a valid letter (1-26)
            if (i + 1 < n) {
                // Parse the 2-digit number segment
                int doubleDigit = Integer.parseInt(s.substring(i, i + 2));
                
                // If it falls within our alphabet range (1 to 26), add its combinations
                if (doubleDigit >= 1 && doubleDigit <= map.size()) { // map.size() is 26
                    dp[i] += dp[i + 2];
                }
            }
        }

        // Return the accumulated combinations calculated at the starting position
        return dp[0];



    }
}
