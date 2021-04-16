package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumSwapsToGroupAllOnesTogether_1151Test {
  private final MinimumSwapsToGroupAllOnesTogether_1151 solution =
      new MinimumSwapsToGroupAllOnesTogether_1151();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 0, 1, 0, 1}, 1),
          arguments(new int[] {0, 0, 0, 1, 0}, 0),
          arguments(new int[] {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1}, 3),
          arguments(
              new int[] {
                1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0,
                0, 1, 1, 1, 1, 0, 0, 1
              },
              8));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minSwaps(int[] arr, int expectedResult) {
    int actualResult = solution.minSwaps(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
