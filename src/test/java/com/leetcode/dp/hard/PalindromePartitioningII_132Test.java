package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PalindromePartitioningII_132Test {

  private final PalindromePartitioningII_132.TopDown solutionTopDown =
      new PalindromePartitioningII_132.TopDown();
  private final PalindromePartitioningII_132.ExpandAroundCenter solutionExpandAroundCenter =
      new PalindromePartitioningII_132.ExpandAroundCenter();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("aab", 1), arguments("a", 0), arguments("ab", 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCutTopDown(String str, int expectedResult) {
    int actualResult = solutionTopDown.minCut(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCutExpandAroundCenter(String str, int expectedResult) {
    int actualResult = solutionExpandAroundCenter.minCut(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
