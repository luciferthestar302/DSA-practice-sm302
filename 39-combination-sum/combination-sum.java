class Solution {
    
    void getAllCombs(int[] arr, int idx, List<Integer> combin, List<List<Integer>> ans, int target){
        //base case condition
        if(idx==arr.length || target<0){
            return;
        }

        if(target==0){ 
            ans.add(new ArrayList<>(combin)); 
            return; //once added, nothing to explore
            
        }

        
        combin.add(arr[idx]);//choosing the current element including in the combin

        
        getAllCombs(arr, idx, combin, ans, target-arr[idx]); //Multiple Inclusion call: stay at same index, allowing arr[idx] to be reused again
        combin.remove(combin.size()-1); // Backtrack: undo the choice so combin is restored to its previous state

        getAllCombs(arr, idx+1, combin, ans, target);
 
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();
        getAllCombs(candidates, 0, combin, ans, target);

        return ans;
        
    }
}