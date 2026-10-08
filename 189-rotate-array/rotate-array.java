class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n; // we have done it necessarily because in some test cases k > n, so in that case we need to decrease the k value using modulo n
        if(k==0) return;

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    public static void reverse(int[] nums, int i, int j){
        
        while(i<j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

    }
}