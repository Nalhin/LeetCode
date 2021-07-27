package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ThreeSumClosest_16Test {
  private final ThreeSumClosest_16 solution = new ThreeSumClosest_16();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {-1, 2, 1, -4}, 1, 2),
          arguments(new int[] {1, 2, 4, 8, 16, 32, 64, 128}, 82, 82),
          arguments(new int[] {1, 1, 1, 0}, -100, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void threeSumClosest(int[] arr, int target, int expectedResult) {
    int actualResult = solution.threeSumClosest(arr, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
