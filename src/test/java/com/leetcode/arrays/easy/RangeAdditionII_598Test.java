package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RangeAdditionII_598Test {

  private final RangeAdditionII_598 solution = new RangeAdditionII_598();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, 3, new int[][] {{2, 2}, {3, 3}}, 4),
          arguments(
              3,
              3,
              new int[][] {
                {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3},
                {3, 3}, {3, 3}
              },
              4),
          arguments(3, 3, new int[][] {}, 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxCount(int m, int n, int[][] ops, int expectedResult) {
    int actualResult = solution.maxCount(m, n, ops);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
