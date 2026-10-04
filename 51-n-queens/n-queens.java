class Solution {
    List<List<String>> result = new ArrayList<>();
    int N;
    Set<Integer> cols = new HashSet<>();
    Set<Integer> Diags = new HashSet<>();
    Set<Integer> antiDiags = new HashSet<>();

    void solve(List<String> Board, int row){
        if(row>=N){
            result.add(new ArrayList<>(Board));
            return;
        }
        for(int col=0;col<N;col++){
            int DiagConst = row+col;
            int antiDiagConst = row-col;   
            
            if (cols.contains(col) || Diags.contains(DiagConst) || antiDiags.contains(antiDiagConst)) {
                continue;
            }
            cols.add(col);
            Diags.add(DiagConst);
            antiDiags.add(antiDiagConst);


            String s = Board.get(row);
            Board.set(row, s.substring(0, col) + 'Q' + s.substring(col + 1));


            solve(Board, row+1);
            
            cols.remove(col);
            Diags.remove(DiagConst);
            antiDiags.remove(antiDiagConst);

            s = Board.get(row);
            Board.set(row, s.substring(0, col) + '.' + s.substring(col + 1));
        }
    }

    public List<List<String>> solveNQueens(int n) {
        N = n;
        List<String> Board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Board.add(".".repeat(n));
        }




        solve(Board, 0);

        return result;
        
    }
    
}