package com.leetcode.design.medium;

import com.leetcode.design.medium.DesignAddAndSearchWordsDataStructure_211.WordDictionary;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class DesignAddAndSearchWordsDataStructure_211Test {

  @Test
  void acceptanceTest() {
    WordDictionary wordDictionary = new WordDictionary();
    SoftAssertions softAssertions = new SoftAssertions();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");

    softAssertions.assertThat(wordDictionary.search("pad")).isFalse();
    softAssertions.assertThat(wordDictionary.search("bad")).isTrue();
    softAssertions.assertThat(wordDictionary.search(".ad")).isTrue();
    softAssertions.assertThat(wordDictionary.search("b..")).isTrue();
    softAssertions.assertAll();
  }
}
