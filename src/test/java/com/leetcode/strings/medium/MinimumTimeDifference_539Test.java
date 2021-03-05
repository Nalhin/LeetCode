package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumTimeDifference_539Test {
  MinimumTimeDifference_539 solution = new MinimumTimeDifference_539();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(List.of("23:59", "00:00"), 1),
          arguments(List.of("00:00", "23:59", "00:00"), 0),
          arguments(List.of("23:59", "00:01"), 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMinDifference(List<String> timePoints, int expectedResult) {
    int actualResult = solution.findMinDifference(timePoints);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
