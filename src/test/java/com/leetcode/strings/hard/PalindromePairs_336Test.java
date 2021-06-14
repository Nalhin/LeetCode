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

class PalindromePairs_336Test {

  private final PalindromePairs_336 solution = new PalindromePairs_336();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"abcd", "dcba", "lls", "s", "sssll"},
              List.of(List.of(0, 1), List.of(1, 0), List.of(3, 2), List.of(2, 4))),
          arguments(new String[] {"bat", "tab", "cat"}, List.of(List.of(0, 1), List.of(1, 0))),
          arguments(new String[] {"a", ""}, List.of(List.of(0, 1), List.of(1, 0))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void palindromePairs(String[] words, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.palindromePairs(words);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
