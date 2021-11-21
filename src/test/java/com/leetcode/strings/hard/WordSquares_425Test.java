package com.leetcode.strings.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordSquares_425Test {

  private final WordSquares_425 solution = new WordSquares_425();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"area", "lead", "wall", "lady", "ball"},
              List.of(
                  List.of("ball", "area", "lead", "lady"),
                  List.of("wall", "area", "lead", "lady"))),
          arguments(
              new String[] {"abat", "baba", "atan", "atal"},
              List.of(
                  List.of("baba", "abat", "baba", "atal"),
                  List.of("baba", "abat", "baba", "atan"))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void wordSquares(String[] words, List<List<String>> expectedResult) {
    List<List<String>> actualResult = solution.wordSquares(words);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
