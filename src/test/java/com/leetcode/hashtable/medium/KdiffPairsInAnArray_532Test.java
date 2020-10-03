package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KdiffPairsInAnArray_532Test {
  private final KdiffPairsInAnArray_532 solution = new KdiffPairsInAnArray_532();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 1, 4, 1, 5}, 2, 2),
          arguments(new int[] {1, 2, 3, 4, 5}, 1, 4),
          arguments(new int[] {1, 3, 1, 5, 4}, 0, 1),
          arguments(new int[] {1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3, 2),
          arguments(new int[] {-1, -2, -3}, 1, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findPairs(int[] input, int k, int expectedResult) {

    int actualResult = solution.findPairs(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
