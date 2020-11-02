package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArithmeticSlices_413Test {
  private final ArithmeticSlices_413 solution = new ArithmeticSlices_413();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4}, 3),
          arguments(new int[] {1, 2, 3}, 1),
          arguments(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 21));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numberOfArithmeticSlices(int[] A, int expectedResult) {
    int actualResult = solution.numberOfArithmeticSlices(A);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
