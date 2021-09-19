package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArithmeticSlicesIISubsequence_446Test {

  private final ArithmeticSlicesIISubsequence_446 solution =
      new ArithmeticSlicesIISubsequence_446();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 4, 6, 8, 10}, 7), arguments(new int[] {7, 7, 7, 7, 7}, 16));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numberOfArithmeticSlices(int[] nums, int expectedResult) {
    int actualResult = solution.numberOfArithmeticSlices(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
