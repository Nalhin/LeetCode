package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PartitionArrayForMaximumSum_1043Test {

  private final PartitionArrayForMaximumSum_1043 solution = new PartitionArrayForMaximumSum_1043();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 15, 7, 9, 2, 5, 10}, 3, 84),
          arguments(new int[] {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4, 83),
          arguments(new int[] {1}, 1, 1),
          arguments(new int[] {7, 2}, 1, 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxSumAfterPartitioning(int[] arr, int k, int expectedResult) {
    int actualResult = solution.maxSumAfterPartitioning(arr, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
