package com.leetcode.strings.easy;

// you are given a string text of words that are placed among some number of spac
// es. each word consists of one or more lowercase english letters and are separate
// d by at least one space. it's guaranteed that text contains at least one word.
//
// rearrange the spaces so that there is an equal number of spaces between every
// pair of adjacent words and that number is maximized. if you cannot redistribute
// all the spaces equally, place the extra spaces at the end, meaning the returned
// string should be the same length as text.
//
// return the string after rearranging the spaces.
//
//
// example 1:
//
//
// input: text = "  this   is  a sentence "
// output: "this   is   a   sentence"
// explanation: there are a total of 9 spaces and 4 words. we can evenly divide t
// he 9 spaces between the words: 9 / (4-1) = 3 spaces.
//
//
// example 2:
//
//
// input: text = " practice   makes   perfect"
// output: "practice   makes   perfect "
// explanation: there are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces p
// lus 1 extra space. we place this extra space at the end of the string.
//
//
// example 3:
//
//
// input: text = "hello   world"
// output: "hello   world"
//
//
// example 4:
//
//
// input: text = "  walks  udp package   into  bar a"
// output: "walks  udp  package  into  bar  a "
//
//
// example 5:
//
//
// input: text = "a"
// output: "a"
//
//
//
// constraints:
//
//
// 1 <= text.length <= 100
// text consists of lowercase english letters and ' '.
// text contains at least one word.
//
// related topics string
// 👍 117 👎 125

// leetcode submit region begin(prohibit modification and deletion)
/*
 O(n) Runtime: 4 ms, faster than 56.54% of Java online submissions for Rearrange Spaces Between Words.
 O(n) Memory Usage: 37.6 MB, less than 35.81% of Java online submissions for Rearrange Spaces Between Words.
*/
public class RearrangeSpacesBetweenWords_1592 {
  public String reorderSpaces(String text) {
    int spaces = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == ' ') {
        spaces++;
      }
    }

    String[] words = text.trim().split("\\s+");
    int numOfWords = words.length;

    int midSpaces = numOfWords != 1 ? spaces / (numOfWords - 1) : 0;
    int endSpaces = numOfWords == 1 ? spaces : spaces % (numOfWords - 1);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numOfWords - 1; i++) {
      sb.append(words[i]);
      sb.append(" ".repeat(Math.max(0, midSpaces)));
    }

    sb.append(words[numOfWords - 1]);
    sb.append(" ".repeat(Math.max(0, endSpaces)));

    return sb.toString();
  }
}
