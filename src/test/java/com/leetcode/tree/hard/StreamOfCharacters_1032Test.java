package com.leetcode.tree.hard;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StreamOfCharacters_1032Test {
  @Nested
  class PrefixList {
    @Test
    void acceptanceTest() {
      StreamOfCharacters_1032.PrefixList.StreamChecker streamChecker =
          new StreamOfCharacters_1032.PrefixList.StreamChecker(new String[] {"cd", "f", "kl"});
      SoftAssertions softAssertions = new SoftAssertions();

      softAssertions.assertThat(streamChecker.query('a')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('b')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('c')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('d')).isEqualTo(true);
      softAssertions.assertThat(streamChecker.query('e')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('f')).isEqualTo(true);
      softAssertions.assertThat(streamChecker.query('g')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('h')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('i')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('j')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('k')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('l')).isEqualTo(true);

      softAssertions.assertAll();
    }
  }

  @Nested
  class Reversed {
    @Test
    void acceptanceTest() {
      StreamOfCharacters_1032.Reversed.StreamChecker streamChecker =
          new StreamOfCharacters_1032.Reversed.StreamChecker(new String[] {"cd", "f", "kl"});
      SoftAssertions softAssertions = new SoftAssertions();

      softAssertions.assertThat(streamChecker.query('a')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('b')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('c')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('d')).isEqualTo(true);
      softAssertions.assertThat(streamChecker.query('e')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('f')).isEqualTo(true);
      softAssertions.assertThat(streamChecker.query('g')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('h')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('i')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('j')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('k')).isEqualTo(false);
      softAssertions.assertThat(streamChecker.query('l')).isEqualTo(true);

      softAssertions.assertAll();
    }
  }
}
