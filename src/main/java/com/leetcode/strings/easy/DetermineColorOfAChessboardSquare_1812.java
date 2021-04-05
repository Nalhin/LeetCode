package com.leetcode.strings.easy;

// You are given coordinates, a string that represents the coordinates of a squar
// e of the chessboard. Below is a chessboard for your reference.
//
//
//
// Return true if the square is white, and false if the square is black.
//
// The coordinate will always represent a valid chessboard square. The coordinat
// e will always have the letter first, and the number second.
//
//
// Example 1:
//
//
// Input: coordinates = "a1"
// Output: false
// Explanation: From the chessboard above, the square with coordinates "a1" is bl
// ack, so return false.
//
//
// Example 2:
//
//
// Input: coordinates = "h3"
// Output: true
// Explanation: From the chessboard above, the square with coordinates "h3" is wh
// ite, so return true.
//
//
// Example 3:
//
//
// Input: coordinates = "c7"
// Output: false
//
//
//
// Constraints:
//
//
// coordinates.length == 2
// 'a' <= coordinates[0] <= 'h'
// '1' <= coordinates[1] <= '8'
//
// Related Topics String
// 👍 53 👎 2
/*
  O(1) Runtime: 0 ms, faster than 100.00% of Java online submissions for Determine Color of a Chessboard Square.
  O(1) Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Determine Color of a Chessboard Square.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class DetermineColorOfAChessboardSquare_1812 {
  public boolean squareIsWhite(String coordinates) {
    int num = Character.getNumericValue(coordinates.charAt(1));
    int letterAsNum = coordinates.charAt(0) - 'a' + 1;
    return num % 2 == 0 ? letterAsNum % 2 == 1 : letterAsNum % 2 == 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
