package com.leetcode.hashtable.easy;

// Tic-tac-toe is played by two players A and B on a 3 x 3 grid.
//
// Here are the rules of Tic-Tac-Toe:
//
//
// Players take turns placing characters into empty squares (" ").
// The first player A always places "X" characters, while the second player B
// always places "O" characters.
// "X" and "O" characters are always placed into empty squares, never on filled
// ones.
// The game ends when there are 3 of the same (non-empty) character filling any
// row, column, or diagonal.
// The game also ends if all squares are non-empty.
// No more moves can be played if the game is over.
//
//
// Given an array moves where each element is another array of size 2
// corresponding to the row and column of the grid where they mark their respective
// character in the order in which A and B play.
//
// Return the winner of the game if it exists (A or B), in case the game ends
// in a draw return "Draw", if there are still movements to play return "Pending".
//
// You can assume that moves is valid (It follows the rules of Tic-Tac-Toe),
// the grid is initially empty and A will play first.
//
//
// Example 1:
//
//
// Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
// Output: "A"
// Explanation: "A" wins, he always plays first.
// "X  "    "X  "    "X  "    "X  "    "X  "
// "   " -> "   " -> " X " -> " X " -> " X "
// "   "    "O  "    "O  "    "OO "    "OOX"
//
//
// Example 2:
//
//
// Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
// Output: "B"
// Explanation: "B" wins.
// "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
// "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
// "   "    "   "    "   "    "   "    "   "    "O  "
//
//
// Example 3:
//
//
// Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
// Output: "Draw"
// Explanation: The game ends in a draw since there are no moves to make.
// "XXO"
// "OOX"
// "XOX"
//
//
// Example 4:
//
//
// Input: moves = [[0,0],[1,1]]
// Output: "Pending"
// Explanation: The game has not finished yet.
// "X  "
// " O "
// "   "
//
//
//
// Constraints:
//
//
// 1 <= moves.length <= 9
// moves[i].length == 2
// 0 <= moves[i][j] <= 2
// There are no repeated elements on moves.
// moves follow the rules of tic tac toe.
// Related Topics Array Hash Table Matrix Simulation 👍 534 👎 144
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Winner on a Tic Tac Toe Game.
 O(m) Memory Usage: 36.8 MB, less than 37.00% of Java online submissions for Find Winner on a Tic Tac Toe Game.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class FindWinnerOnATicTacToeGame_1275 {

  private static final String A_WINS = "A";
  private static final String B_WINS = "B";
  private static final String DRAW = "Draw";
  private static final String PENDING = "Pending";

  private static final int N = 3;

  public String tictactoe(int[][] moves) {
    int[] rows = new int[N];
    int[] cols = new int[N];
    int diagonal = 0;
    int counterDiagonal = 0;

    for (int i = 0; i < moves.length; i++) {
      int sign = i % 2 == 0 ? 1 : -1;
      int[] curr = moves[i];

      int row = curr[0];
      int col = curr[1];

      rows[row] += sign;
      cols[col] += sign;

      diagonal += row == col ? sign : 0;
      counterDiagonal += row == N - 1 - col ? sign : 0;

      int goal = N * sign;

      if (rows[row] == goal || cols[col] == goal || diagonal == goal || counterDiagonal == goal) {
        return sign == 1 ? A_WINS : B_WINS;
      }
    }

    return moves.length == N * N ? DRAW : PENDING;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
