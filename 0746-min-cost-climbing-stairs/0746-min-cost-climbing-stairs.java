class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if(n<=2) return Math.min(first, second);
        for(int i = 2 ; i < cost.length ; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        return Math.min(first, second);
    }
}

        
        
        
        
//         int step1 = 0;
//         int step2 = 0;
//         for(int i = cost.length - 1;i>=0;i--) {
//             int currentStep = cost[i] + Math.min(step1, step2);
//             step1 = step2;
//             step2 = currentStep;
//         }
//         return Math.min(step1, step2);
//     }
// }