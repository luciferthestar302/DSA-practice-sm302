class Solution {
    public int findMin(int[] nums) {
        int left = 0; int right = nums.length-1;
        while(left<right){  //left<=right is not used because at a point left = right, so if we use left<=right, the while loop becomes an infite loop
            int mid = left +(right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}