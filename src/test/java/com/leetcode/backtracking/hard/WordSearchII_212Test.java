package com.leetcode.backtracking.hard;

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

class WordSearchII_212Test {

  private final WordSearchII_212 solution = new WordSearchII_212();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new char[][] {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
              },
              new String[] {"oath", "pea", "eat", "rain"},
              List.of("eat", "oath")),
          arguments(
              new char[][] {{'a', 'b'}, {'c', 'd'}},
              new String[] {"abcb"},
              Collections.emptyList()),
          arguments(
              new char[][] {{'a', 'b'}, {'c', 'd'}}, new String[]{"abcb"}, Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findWords(char[][] board, String[] words, List<String> expectedResult) {
    List<String> actualResult = solution.findWords(board, words);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
