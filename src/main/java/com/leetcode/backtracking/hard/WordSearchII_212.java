package com.leetcode.backtracking.hard;

// Given an m x n board of characters and a list of strings words, return all
// words on the board.
//
// Each word must be constructed from letters of sequentially adjacent cells,
// where adjacent cells are horizontally or vertically neighboring. The same letter
// cell may not be used more than once in a word.
//
//
// Example 1:
//
//
// Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i",
// "f","l","v"]], words = ["oath","pea","eat","rain"]
// Output: ["eat","oath"]
//
//
// Example 2:
//
//
// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []
//
//
//
// Constraints:
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] is a lowercase English letter.
// 1 <= words.length <= 3 * 10⁴
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// All the strings of words are unique.
//
// Related Topics Array String Backtracking Trie Matrix 👍 4683 👎 161
/*
  O(n*m^(word length))   Runtime: 128 ms, faster than 67.53% of Java online submissions for Word Search II.
  O(n*m + words.length * word length) Memory Usage: 39.3 MB, less than 50.16% of Java online submissions for Word Search II.
 */
import java.util.ArrayList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)

public class WordSearchII_212 {
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public List<String> findWords(char[][] board, String[] words) {

    TrieNode trie = new TrieNode();
    for (String word : words) {

      TrieNode curr = trie;
      for (int i = 0; i < word.length(); i++) {

        int charHash = word.charAt(i) - 'a';
        if (curr.children[charHash] == null) {
          curr.children[charHash] = new TrieNode();
        }
        curr = curr.children[charHash];
      }
      curr.isEnd = true;
      curr.str = word;
    }

    List<String> result = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        backtrack(
            i,
            j,
            trie.children[board[i][j] - 'a'],
            new boolean[board.length][board[0].length],
            board,
            result);
      }
    }

    return result;
  }

  private void backtrack(
      int currRow,
      int currCol,
      TrieNode trie,
      boolean[][] visited,
      char[][] board,
      List<String> result) {
    if (trie == null || visited[currRow][currCol]) {
      return;
    }

    visited[currRow][currCol] = true;

    if (trie.isEnd) {
      result.add(trie.str);
      trie.isEnd = false;
    }

    for (int[] direction : DIRECTIONS) {
      int newRow = currRow + direction[0];
      int newCol = currCol + direction[1];

      if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
        backtrack(
            newRow, newCol, trie.children[board[newRow][newCol] - 'a'], visited, board, result);
      }
    }

    visited[currRow][currCol] = false;
  }

  private static class TrieNode {
    private final TrieNode[] children = new TrieNode[26];
    private boolean isEnd;
    private String str;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
