package com.leetcode.arrays.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumValueToGetPositiveStepByStepSum_1413Test {

  private final MinimumValueToGetPositiveStepByStepSum_1413 solution =
      new MinimumValueToGetPositiveStepByStepSum_1413();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {-3, 2, -3, 4, 2}, 5),
          arguments(new int[] {1, 2}, 1),
          arguments(new int[] {1, -2, -3}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minStartValue(int[] input, int expectedResult) {
    int actualResult = solution.minStartValue(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
