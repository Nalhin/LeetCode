package com.leetcode.hashtable.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfValidWordsForEachPuzzle_1178Test {

  private final NumberOfValidWordsForEachPuzzle_1178 solution =
      new NumberOfValidWordsForEachPuzzle_1178();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
              new String[] {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"},
              List.of(1, 1, 3, 2, 4, 0)),
          arguments(
              new String[] {"apple", "pleas", "please"},
              new String[] {"aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy"},
              List.of(0, 1, 3, 2, 0)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findNumOfValidWords(String[] words, String[] puzzles, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.findNumOfValidWords(words, puzzles);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
