package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortestWordDistance_243Test {

  private final ShortestWordDistance_243 solution = new ShortestWordDistance_243();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(
              new String[] {"practice", "makes", "perfect", "coding", "makes"},
              "coding",
              "practice",
              3),
          arguments(
              new String[] {"practice", "makes", "perfect", "coding", "makes"},
              "makes",
              "coding",
              1),
          arguments(new String[] {"a", "a", "b", "b"}, "a", "b", 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shortestDistance(String[] words, String word1, String word2, int expected) {
    int result = solution.shortestDistance(words, word1, word2);

    assertThat(result).isEqualTo(expected);
  }
}
