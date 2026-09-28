class Solution {
    int n;
    Set<Integer> st = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();
    void solve(List<Integer> temp, int [] nums){

        if(temp.size()==n){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(!st.contains(nums[i])){
                temp.add(nums[i]);
                st.add(nums[i]);

                solve(temp, nums);
                
                temp.remove(temp.size() - 1);
                st.remove(nums[i]);
            }
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<Integer> temp = new ArrayList<>();
        solve(temp, nums);
        return result;
    }
}