package first.bytype.backtrack;

public class t37 {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)){
                        board[i][j] = k;
                        if (backtrack(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char k, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k){
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == k){
                    return false;
                }
            }
        }
        return true;
    }
}
