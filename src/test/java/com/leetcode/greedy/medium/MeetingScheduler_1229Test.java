package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MeetingScheduler_1229Test {
  private final MeetingScheduler_1229 solution = new MeetingScheduler_1229();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{10, 50}, {60, 120}, {140, 210}},
              new int[][] {{0, 15}, {60, 70}},
              8,
              List.of(60, 68)),
          arguments(
              new int[][] {{10, 50}, {60, 120}, {140, 210}},
              new int[][] {{0, 15}, {60, 70}},
              12,
              Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minAvailableDuration(
      int[][] slots1, int[][] slots2, int duration, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.minAvailableDuration(slots1, slots2, duration);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
