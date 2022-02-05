package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountWordsObtainedAfterAddingALetter_2135Test {

  private final CountWordsObtainedAfterAddingALetter_2135 solution =
      new CountWordsObtainedAfterAddingALetter_2135();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"ant", "act", "tack"}, new String[] {"tack", "act", "acti"}, 2),
          arguments(new String[] {"ab", "a"}, new String[] {"abc", "abcd"}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void wordCount(String[] startWords, String[] targetWords, int expectedResult) {
    int actualResult = solution.wordCount(startWords, targetWords);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
