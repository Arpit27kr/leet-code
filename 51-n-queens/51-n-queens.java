import java.util.*;
class Solution {
  private List<int[]> validBoards;
  private int n;
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    if (n == 0) return res;
    if (n == 1) {
      List<String> b = new ArrayList<>();
      b.add("Q");
      res.add(b);
      return res;
    }
    // do dfs
    validBoards = new ArrayList<>();
    this.n = n;
    dfs(new int[n], 0);
    // convert result
    for (int[] b: validBoards) {
      String[] temp = new String[n];
      for (int c = 0; c < n; c++) {
        for (int r = 0; r < n; r++) {
          if (r == b[c]) temp[r] = (temp[r] == null) ? "Q" : temp[r] + "Q";else temp[r] = (temp[r] == null) ? "." : temp[r] + ".";
        }
      }
      res.add(Arrays.asList(temp));
    }
    return res;
  }
  private void dfs(int[] board, int col) {
    if (col == n) {
      validBoards.add(board.clone());
    } else {
      for (int r = 0; r < n; r++) {
        if (isValid(board, col, r)) {
          board[col] = r;
          dfs(board, col + 1);
        }
      }
    }
  }
  private boolean isValid(int[] board, int col, int row) {
    if (col == 0) return true;
    for (int c = 0; c < col; c++) {
      if (board[c] == row || Math.abs(board[c] - row) == col - c)
        return false;
    }
    return true;
  }
}