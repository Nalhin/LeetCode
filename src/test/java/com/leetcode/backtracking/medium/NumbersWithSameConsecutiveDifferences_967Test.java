package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumbersWithSameConsecutiveDifferences_967Test {

  private final NumbersWithSameConsecutiveDifferences_967 solution = new NumbersWithSameConsecutiveDifferences_967();

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numsSameConsecDiff(int n, int k, int[] expectedResult) {
    int[] actualResult = solution.numsSameConsecDiff(n, k);

    assertThat(actualResult).containsExactlyInAnyOrder(expectedResult);
  }

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, 7, new int[]{181, 292, 707, 818, 929}), arguments(2, 1, new int[]{10, 12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98}));
    }
  }
}