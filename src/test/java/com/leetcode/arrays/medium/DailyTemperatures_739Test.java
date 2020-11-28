package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DailyTemperatures_739Test {

  private final DailyTemperatures_739 solution = new DailyTemperatures_739();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {73, 74, 75, 71, 69, 72, 76, 73}, new int[] {1, 1, 4, 2, 1, 1, 0, 0}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void dailyTemperatures(int[] input, int[] expectedResult) {
    int[] actualResult = solution.dailyTemperatures(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
