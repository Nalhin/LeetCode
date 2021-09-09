package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestPlusSign_764Test {

  private final LargestPlusSign_764 solution = new LargestPlusSign_764();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(5, new int[][] {{4, 2}}, 2), arguments(1, new int[][] {{0, 0}}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void orderOfLargestPlusSign(int n, int[][] mines, int expectedResult) {
    int actualResult = solution.orderOfLargestPlusSign(n, mines);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
