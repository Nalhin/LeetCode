package com.leetcode.graph.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestPathWithDifferentAdjacentCharacters_2246Test {

  private final LongestPathWithDifferentAdjacentCharacters_2246 solution =
      new LongestPathWithDifferentAdjacentCharacters_2246();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {-1, 0, 0, 1, 1, 2}, "abacbe", 3),
          arguments(new int[] {-1, 0, 0, 0}, "aabc", 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestPath(int[] parent, String s, int expectedResult) {
    int actualResult = solution.longestPath(parent, s);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
