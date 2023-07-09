class Solution {
    public int longestPalindromeSubseq(String s) {
        String t= new StringBuilder(s).reverse().toString();
        return lcs(s, t);
    }
    
    public int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++) {
            dp[0][i] = 0;
        }
        for(int i=0;i<=m;i++) {
            dp[i][0] = 0;
        }
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
    
//     String reverse(String t) {
//         int start = 0;
//         int end = t.length()-1;
//         while(start<=end) {
//             swap(t, start, end);
//             start++;
//             end--;
//         }
//     }
    
//     void swap(String t, int i, int j) {
//         char temp = t.charAt(i);
//         t.charAt(i) = t.charAt(j);
//         t.charAt(j) = temp;
//     }
// }