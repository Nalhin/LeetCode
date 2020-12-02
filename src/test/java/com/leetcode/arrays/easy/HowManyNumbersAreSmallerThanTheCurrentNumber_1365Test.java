package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HowManyNumbersAreSmallerThanTheCurrentNumber_1365Test {
  private final HowManyNumbersAreSmallerThanTheCurrentNumber_1365 solution =
      new HowManyNumbersAreSmallerThanTheCurrentNumber_1365();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {8, 1, 2, 2, 3}, new int[] {4, 0, 1, 1, 3}),
          arguments(new int[] {6, 5, 4, 8}, new int[] {2, 1, 0, 3}),
          arguments(new int[] {7, 7, 7, 7}, new int[] {0, 0, 0, 0}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void smallerNumbersThanCurrent(int[] input, int[] expectedResult) {
    int[] actualResult = solution.smallerNumbersThanCurrent(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
