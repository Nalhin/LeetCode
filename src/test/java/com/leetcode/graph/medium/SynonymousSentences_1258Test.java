package com.leetcode.graph.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SynonymousSentences_1258Test {

  private final SynonymousSentences_1258 solution = new SynonymousSentences_1258();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              List.of(
                  List.of("happy", "joy"), List.of("sad", "sorrow"), List.of("joy", "cheerful")),
              "I am happy today but was sad yesterday",
              List.of(
                  "I am cheerful today but was sad yesterday",
                  "I am cheerful today but was sorrow yesterday",
                  "I am happy today but was sad yesterday",
                  "I am happy today but was sorrow yesterday",
                  "I am joy today but was sad yesterday",
                  "I am joy today but was sorrow yesterday")),
          arguments(
              List.of(List.of("happy", "joy"), List.of("cheerful", "glad")),
              "I am happy today but was sad yesterday",
              List.of(
                  "I am happy today but was sad yesterday",
                  "I am joy today but was sad yesterday")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void generateSentences(List<List<String>> synonyms, String text, List<String> expectedResult) {
    List<String> actualResult = solution.generateSentences(synonyms, text);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
