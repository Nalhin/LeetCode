package com.leetcode.bfs.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordLadder_127Test {

  private final WordLadder_127 solution = new WordLadder_127();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"), 5),
          arguments("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"), 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void ladderLength(String beginWord, String endWord, List<String> wordList, int expectedResult) {
    int actualResult = solution.ladderLength(beginWord, endWord, wordList);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
