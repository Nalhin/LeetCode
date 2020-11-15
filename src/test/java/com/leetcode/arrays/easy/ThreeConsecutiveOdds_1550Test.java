package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ThreeConsecutiveOdds_1550Test {

  private final ThreeConsecutiveOdds_1550 solution = new ThreeConsecutiveOdds_1550();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 6, 4, 1}, false),
          arguments(new int[] {1, 2, 34, 3, 4, 5, 7, 23, 12}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void threeConsecutiveOdds(int[] input, boolean expectedResult) {

    boolean actualResult = solution.threeConsecutiveOdds(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
