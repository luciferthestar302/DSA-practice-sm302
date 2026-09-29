class Solution {
    static Integer[][] memo;

    static int solve(int i, int j, int[] nums){
        //base conditions
        if(i>j) return 0;

        if(i==j) return nums[i];

        if(memo[i][j]!=null) return memo[i][j]; //agar already solved hai return it directly

        //Two best possible scenario for P1
        int take_i = nums[i] + Math.min(solve(i+2, j, nums), solve(i+1, j-1, nums));
        int take_j = nums[j] + Math.min(solve(i+1, j-1, nums), solve(i, j-2, nums));

        memo[i][j] = Math.max(take_i, take_j);

        return memo[i][j];

    }






    public boolean predictTheWinner(int[] nums) {
        int total_score = 0;
        int n = nums.length;
        memo = new Integer[n][n];
        
        for(int i=0;i<nums.length;i++){
            total_score+= nums[i];
        }
        int P1_score = solve(0, n-1, nums);
        int P2_score = total_score- P1_score;

        return P1_score>=P2_score;
    }
}