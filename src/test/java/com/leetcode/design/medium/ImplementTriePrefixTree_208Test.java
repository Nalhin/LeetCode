package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class ImplementTriePrefixTree_208Test {

  @Test
  void acceptanceTest() {
    ImplementTriePrefixTree_208.Trie trie = new ImplementTriePrefixTree_208.Trie();

    SoftAssertions softAssertions = new SoftAssertions();

    trie.insert("apple");
    softAssertions.assertThat(trie.search("apple")).isTrue();
    softAssertions.assertThat(trie.search("app")).isFalse();
    softAssertions.assertThat(trie.startsWith("app")).isTrue();
    trie.insert("app");
    softAssertions.assertThat(trie.search("app")).isTrue();
    softAssertions.assertAll();
  }
}
