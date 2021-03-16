package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordSubsets_916Test {

  private final WordSubsets_916 solution = new WordSubsets_916();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
              new String[] {"e", "o"},
              List.of("facebook", "google", "leetcode")),
          arguments(
              new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
              new String[] {"e", "l"},
              List.of("apple", "google", "leetcode")),
          arguments(
              new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
              new String[] {"e", "oo"},
              List.of("facebook", "google")),
          arguments(
              new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
              new String[] {"lo", "eo"},
              List.of("google", "leetcode")),
          arguments(
              new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
              new String[] {"ec", "oc", "ceo"},
              List.of("facebook", "leetcode")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void wordSubsets(String[] A, String[] B, List<String> expectedResult) {
    List<String> actualResult = solution.wordSubsets(A, B);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
