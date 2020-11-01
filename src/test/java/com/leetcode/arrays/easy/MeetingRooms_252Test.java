package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MeetingRooms_252Test {

  private final MeetingRooms_252 solution = new MeetingRooms_252();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 30}, {5, 10}, {15, 20}}, false),
          arguments(new int[][] {{7, 10}, {2, 4}}, true),
          arguments(new int[][] {{2, 7}, {7, 10}}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canAttendMeetings(int[][] intervals, boolean expectedResult) {
    boolean actualResult = solution.canAttendMeetings(intervals);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
