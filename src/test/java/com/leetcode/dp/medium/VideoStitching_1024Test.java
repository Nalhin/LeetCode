package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class VideoStitching_1024Test {

  private final VideoStitching_1024 solution = new VideoStitching_1024();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10, 3),
          arguments(new int[][] {{0, 1}, {1, 2}}, 5, -1),
          arguments(
              new int[][] {
                {0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4},
                {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}
              },
              9,
              3),
          arguments(new int[][] {{0, 4}, {2, 8}}, 5, 2),
          arguments(
              new int[][] {{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}},
              5,
              1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void videoStitching(int[][] clips, int t, int expectedResult) {
    int actualResult = solution.videoStitching(clips, t);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
