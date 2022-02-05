package com.leetcode.greedy.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EarliestPossibleDayOfFullBloom_2136Test {

  private final EarliestPossibleDayOfFullBloom_2136 solution =
      new EarliestPossibleDayOfFullBloom_2136();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 4, 3}, new int[] {2, 3, 1}, 9),
          arguments(new int[] {1, 2, 3, 2}, new int[] {2, 1, 2, 1}, 9),
          arguments(new int[] {1}, new int[] {1}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void earliestFullBloom(int[] plantTime, int[] growTime, int expectedResult) {
    int actualResult = solution.earliestFullBloom(plantTime, growTime);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
