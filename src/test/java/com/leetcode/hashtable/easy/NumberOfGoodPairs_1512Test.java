package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfGoodPairs_1512Test {
  private final NumberOfGoodPairs_1512 solution = new NumberOfGoodPairs_1512();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 1, 1, 3}, 4),
          arguments(new int[] {1, 1, 1, 1}, 6),
          arguments(new int[] {1, 2, 3}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numIdenticalPairs(int[] nums, int expectedResult) {
    int actualResult = solution.numIdenticalPairs(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
