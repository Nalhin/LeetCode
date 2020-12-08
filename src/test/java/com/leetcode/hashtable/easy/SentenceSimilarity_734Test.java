package com.leetcode.hashtable.easy;

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

class SentenceSimilarity_734Test {

  private final SentenceSimilarity_734 solution = new SentenceSimilarity_734();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new String[] {"great", "acting", "skills"},
              new String[] {"fine", "drama", "talent"},
              List.of(
                  List.of("great", "fine"),
                  List.of("drama", "acting"),
                  List.of("skills", "talent")),
              true),
          arguments(new String[] {"great"}, new String[] {"great"}, Collections.emptyList(), true),
          arguments(
              new String[] {"great"},
              new String[] {"doubleplus", "good"},
              List.of(List.of("great", "doubleplus")),
              false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void areSentencesSimilar(
      String[] sentence1,
      String[] sentence2,
      List<List<String>> similarPairs,
      boolean expectedResult) {

    boolean actualResult = solution.areSentencesSimilar(sentence1, sentence2, similarPairs);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
