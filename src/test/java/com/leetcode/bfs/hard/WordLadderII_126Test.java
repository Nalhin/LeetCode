package com.leetcode.bfs.hard;

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

class WordLadderII_126Test {
  private final WordLadderII_126 solution = new WordLadderII_126();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(
              "hit",
              "cog",
              List.of("hot", "dot", "dog", "lot", "log", "cog"),
              List.of(
                  List.of("hit", "hot", "dot", "dog", "cog"),
                  List.of("hit", "hot", "lot", "log", "cog"))),
          arguments(
              "hit", "cog", List.of("hot", "dot", "dog", "lot", "log"), Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLadders(
      String beginWord, String endWord, List<String> wordList, List<List<String>> expectedResult) {
    List<List<String>> actualResult = solution.findLadders(beginWord, endWord, wordList);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
