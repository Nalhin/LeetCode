package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubarraySumEqualsK_560Test {
  private final SubarraySumEqualsK_560 solution = new SubarraySumEqualsK_560();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {1, 1, 1}, 2, 2), arguments(new int[] {1, 2, 3}, 3, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void subarraySum(int[] arr, int k, int expectedResult) {
    int actualResult = solution.subarraySum(arr, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
