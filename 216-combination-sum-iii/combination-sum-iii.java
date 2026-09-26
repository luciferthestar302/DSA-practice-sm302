class Solution {
    List<Integer> candidates = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    List<List<Integer>> result = new ArrayList<>();
    void solve(List<Integer> candidates, int target, int k, List<Integer> curr, int idx){
        if(target<0) return;
        if(curr.size()>k)  return;
        if(target==0 && curr.size()==k){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i<candidates.size();i++){
            if(i>idx && candidates.get(i).equals(candidates.get(i-1))){
                continue;
            }
            curr.add(candidates.get(i));
            solve(candidates, target-candidates.get(i), k, curr, i+1);
            curr.remove(curr.size()-1);
        }
    
    }
    
    
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr = new ArrayList<>();
        Collections.sort(candidates);
        solve(candidates, n, k, curr, 0);
        return result;
    }
}