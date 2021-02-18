package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IndexPairsOfAString_1065Test {

  private final IndexPairsOfAString_1065 solution = new IndexPairsOfAString_1065();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              "thestoryofleetcodeandme",
              new String[] {"story", "fleet", "leetcode"},
              new int[][] {{3, 7}, {9, 13}, {10, 17}}),
          arguments(
              "ababa", new String[] {"aba", "ab"}, new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void indexPairs(String word, String[] words, int[][] expectedResult) {
    int[][] actualResult = solution.indexPairs(word, words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
