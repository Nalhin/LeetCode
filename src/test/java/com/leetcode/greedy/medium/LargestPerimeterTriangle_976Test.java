package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestPerimeterTriangle_976Test {

  private final LargestPerimeterTriangle_976 solution = new LargestPerimeterTriangle_976();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 1, 2}, 5),
          arguments(new int[] {1, 2, 1}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void largestPerimeter(int[] nums, int expectedResult) {
    int actualResult = solution.largestPerimeter(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}