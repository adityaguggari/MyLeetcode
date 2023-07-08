class Solution {
    public int climbStairs(int n) {
        if(n <= 3 ) {
            return n;
        }
        
        int n1 = 3;
        int n2 = 2;
        
        for(int i = 0 ; i < n-3 ; i++) {
            n1 = n1 + n2;
            n2 = n1 - n2;
        }
        
        return n1;
    }
}