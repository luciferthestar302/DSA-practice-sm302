class Solution {
public:
    set<vector<int>> s;
    void getAllCombs(vector<int>& arr,int idx,vector<int>& combin, vector<vector<int>> &ans, int target){
        if(idx==arr.size() || target<0){
            return;
        }
        if(target==0){
            if(s.find(combin)==s.end()){
                ans.push_back(combin);
                s.insert(combin);
            }

        }
        combin.push_back(arr[idx]);

        getAllCombs(arr, idx+1, combin, ans, target-arr[idx]); //Single Inclusion Call
        getAllCombs(arr, idx, combin, ans, target-arr[idx]); //Muliple Inclusion Call
        combin.pop_back(); //Backtracking to make it empty again

        getAllCombs(arr, idx+1, combin, ans, target);  //Exclusion Call

     }

    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int>combin;
        getAllCombs(candidates, 0, combin, ans, target);
        return ans;
    }
};