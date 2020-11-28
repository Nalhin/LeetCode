package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PartitionEqualSubsetSum_416Test {

  private final PartitionEqualSubsetSum_416 solution = new PartitionEqualSubsetSum_416();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 5, 11, 5}, true),
          arguments(new int[] {1, 2, 5}, false),
          arguments(new int[] {1, 2, 3, 5}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canPartition(int[] input, boolean expectedResult) {

    boolean actualResult = solution.canPartition(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
