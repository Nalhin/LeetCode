package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KthMissingPositiveNumber_1539Test {

  private final KthMissingPositiveNumber_1539 solution = new KthMissingPositiveNumber_1539();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 3, 4, 7, 11}, 5, 9), arguments(new int[] {1, 2, 3, 4}, 2, 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findKthPositive(int[] arr, int k, int expectedResult) {
    int actualResult = solution.findKthPositive(arr, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
