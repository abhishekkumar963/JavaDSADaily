// 51. N-Queens

class Solution {
    private List<List<String>> solutions = new ArrayList<>();
  
    private int[] columnOccupied;
  
    private int[] mainDiagonal;
  
    private int[] antiDiagonal;
  
    private String[][] board;
  
    private int boardSize;

    public List<List<String>> solveNQueens(int n) {
        this.boardSize = n;
      
        columnOccupied = new int[n];
        mainDiagonal = new int[n * 2];
        antiDiagonal = new int[n * 2];
      
        board = new String[n][n];
        for (int row = 0; row < n; ++row) {
            Arrays.fill(board[row], ".");
        }
      
        placeQueens(0);
      
        return solutions;
    }
    private void placeQueens(int currentRow) {
        if (currentRow == boardSize) {
            List<String> currentSolution = new ArrayList<>();
            for (int row = 0; row < boardSize; ++row) {
                currentSolution.add(String.join("", board[row]));
            }
            solutions.add(currentSolution);
            return;
        }
      
        for (int col = 0; col < boardSize; ++col) {
            if (columnOccupied[col] + mainDiagonal[currentRow + col] + 
                antiDiagonal[boardSize - currentRow + col] == 0) {
              
                board[currentRow][col] = "Q";
              
                columnOccupied[col] = 1;
                mainDiagonal[currentRow + col] = 1;
                antiDiagonal[boardSize - currentRow + col] = 1;
              
                placeQueens(currentRow + 1);
              
                columnOccupied[col] = 0;
                mainDiagonal[currentRow + col] = 0;
                antiDiagonal[boardSize - currentRow + col] = 0;
                board[currentRow][col] = ".";
            }
        }
    }
}
