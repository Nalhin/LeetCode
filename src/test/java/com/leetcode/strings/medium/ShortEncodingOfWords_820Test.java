package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortEncodingOfWords_820Test {
  private final ShortEncodingOfWords_820.Sort solutionSort = new ShortEncodingOfWords_820.Sort();
  private final ShortEncodingOfWords_820.Trie solutionTrie = new ShortEncodingOfWords_820.Trie();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"time", "me", "bell"}, 10),
          arguments(new String[] {"t"}, 2),
          arguments(new String[] {"time", "time", "time", "time"}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calculateSort(String[] words, int expectedResult) {
    int actualResult = solutionSort.minimumLengthEncoding(words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calculateTrie(String[] words, int expectedResult) {
    int actualResult = solutionTrie.minimumLengthEncoding(words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
