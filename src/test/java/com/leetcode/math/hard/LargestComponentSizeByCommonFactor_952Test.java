package com.leetcode.math.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LargestComponentSizeByCommonFactor_952Test {

  private final LargestComponentSizeByCommonFactor_952 solution =
      new LargestComponentSizeByCommonFactor_952();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4, 6, 15, 35}, 4),
          arguments(new int[] {20, 50, 9, 63}, 2),
          arguments(new int[] {2, 3, 6, 7, 4, 12, 21, 39}, 8));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void largestComponentSize(int[] nums, int expectedResult) {
    int actualResult = solution.largestComponentSize(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
