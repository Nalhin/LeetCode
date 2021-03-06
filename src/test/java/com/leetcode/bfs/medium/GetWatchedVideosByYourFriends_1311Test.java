package com.leetcode.bfs.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GetWatchedVideosByYourFriends_1311Test {
  private final GetWatchedVideosByYourFriends_1311 solution =
      new GetWatchedVideosByYourFriends_1311();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              List.of(List.of("A", "B"), List.of("C"), List.of("B", "C"), List.of("D")),
              new int[][] {{1, 2}, {0, 3}, {0, 3}, {1, 2}},
              0,
              1,
              List.of("B", "C")),
          arguments(
              List.of(List.of("A", "B"), List.of("C"), List.of("B", "C"), List.of("D")),
              new int[][] {{1, 2}, {0, 3}, {0, 3}, {1, 2}},
              0,
              2,
              List.of("D")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void watchedVideosByFriends(
      List<List<String>> watchedVideos,
      int[][] friends,
      int id,
      int level,
      List<String> expectedResult) {
    List<String> actualResult = solution.watchedVideosByFriends(watchedVideos, friends, id, level);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
