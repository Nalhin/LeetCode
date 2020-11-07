package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OccurrencesAfterBigram_1078Test {

  private final OccurrencesAfterBigram_1078 solution = new OccurrencesAfterBigram_1078();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(
              "alice is a good girl she is a good student",
              "a",
              "good",
              new String[] {"girl", "student"}),
          arguments("we will we will rock you", "we", "will", new String[] {"we", "rock"}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findOcurrences(String input, String first, String second, String[] expectedResult) {

    String[] actualResult = solution.findOcurrences(input, first, second);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
