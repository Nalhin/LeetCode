package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PartitionArrayIntoDisjointIntervals_915Test {
  private final PartitionArrayIntoDisjointIntervals_915.SuffixMin solutionSuffixMin =
      new PartitionArrayIntoDisjointIntervals_915.SuffixMin();
  private final PartitionArrayIntoDisjointIntervals_915.OnePass solutionOnePass =
      new PartitionArrayIntoDisjointIntervals_915.OnePass();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {5, 0, 3, 8, 6}, 3), arguments(new int[] {1, 1, 1, 0, 6, 12}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void partitionDisjointSuffixMin(int[] array, int expectedResult) {
    int actualResult = solutionSuffixMin.partitionDisjoint(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void partitionDisjointOnePass(int[] array, int expectedResult) {
    int actualResult = solutionOnePass.partitionDisjoint(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
