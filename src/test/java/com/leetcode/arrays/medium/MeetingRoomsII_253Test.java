package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MeetingRoomsII_253Test {

  private final MeetingRoomsII_253 solution = new MeetingRoomsII_253();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 30}, {5, 10}, {15, 20}}, 2),
          arguments(new int[][] {{7, 10}, {2, 4}}, 1),
          arguments(new int[][] {}, 0),
          arguments(new int[][] {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}}, 2),
          arguments(new int[][] {{5, 8}, {6, 8}}, 2),
          arguments(new int[][] {{9, 10}, {4, 9}, {4, 17}}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minMeetingRooms(int[][] input, int expectedResult) {

    int actualResult = solution.minMeetingRooms(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
