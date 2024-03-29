package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumMovesToEqualArrayElementsII_462Test {

  private final MinimumMovesToEqualArrayElementsII_462 solution =
      new MinimumMovesToEqualArrayElementsII_462();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {1, 2, 3}, 2), arguments(new int[] {1, 10, 2, 9}, 16));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minMoves2(int[] nums, int expectedResult) {
    int actualResult = solution.minMoves2(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
