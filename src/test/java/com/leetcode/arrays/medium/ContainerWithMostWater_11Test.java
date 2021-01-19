package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ContainerWithMostWater_11Test {
  private final ContainerWithMostWater_11 solution = new ContainerWithMostWater_11();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
          arguments(new int[] {1, 1}, 1),
          arguments(new int[] {4, 3, 2, 1, 4}, 16),
          arguments(new int[] {1, 2, 1}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxArea(int[] height, int expectedResult) {

    int actualResult = solution.maxArea(height);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
