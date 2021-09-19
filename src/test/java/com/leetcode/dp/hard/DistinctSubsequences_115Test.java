package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DistinctSubsequences_115Test {

  private final DistinctSubsequences_115.Memo solutionMemo = new DistinctSubsequences_115.Memo();
  private final DistinctSubsequences_115.Iterative solutionIterative =
      new DistinctSubsequences_115.Iterative();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("rabbbit", "rabbit", 3), arguments("babgbag", "bag", 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numDistinctMemo(String s, String t, int expectedResult) {
    int actualResult = solutionMemo.numDistinct(s, t);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numDistinctIterative(String s, String t, int expectedResult) {
    int actualResult = solutionIterative.numDistinct(s, t);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
