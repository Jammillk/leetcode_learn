package first.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t51 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtrack(n, 0, chessboard);
        return res;
    }

    private void backtrack(int n, int row, char[][] chessboard) {
        if (n == row){
            res.add(Array2List(chessboard));
            return ;
        }
        for(int col = 0;col < n;col ++){
            if (isValid(row, col, n, chessboard)){
                chessboard[row][col] = 'Q';
                backtrack(n, col + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        for(int i =0;i < row;i++){
            if (chessboard[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col - 1;i >= 0 && j >=0;i--,j--){
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] chars : chessboard) {
            list.add(String.valueOf(chars));
        }
        return list;
    }
}
