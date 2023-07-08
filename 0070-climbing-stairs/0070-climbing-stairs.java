class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i < n+1 ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
  
//         if(n <= 3 ) {
//             return n;
//         }
        
//         int n1 = 3;
//         int n2 = 2;
        
//         for(int i = 0 ; i < n-3 ; i++) {
//             n1 = n1 + n2;
//             n2 = n1 - n2;
//         }
        
//         return n1;
//     }
// }