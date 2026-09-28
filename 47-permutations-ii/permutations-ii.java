class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    void solve(List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size()==n){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(used[i]) continue; //agar already temp added hai toh skip karo

            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue; //duplicate element ko skip karo

            temp.add(nums[i]); //choose
            used[i] = true; //taaki do same values me confusion na ho.

            solve(temp, nums, used);//explore

            temp.remove(temp.size()-1); //undo
            used[i] = false; //undo used boolean ko bhi previous value par set karna padega na
        }
    }








    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        solve(new ArrayList<>(), nums, new boolean[n]);
        return result;
        
    }
}