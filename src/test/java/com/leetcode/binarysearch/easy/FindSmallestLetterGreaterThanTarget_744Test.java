package com.leetcode.binarysearch.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindSmallestLetterGreaterThanTarget_744Test {

  private final FindSmallestLetterGreaterThanTarget_744 solution =
      new FindSmallestLetterGreaterThanTarget_744();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new char[] {'c', 'f', 'j'}, 'a', 'c'),
          arguments(new char[] {'c', 'f', 'j'}, 'c', 'f'),
          arguments(new char[] {'c', 'f', 'j'}, 'd', 'f'),
          arguments(new char[] {'c', 'f', 'j'}, 'd', 'f'),
          arguments(new char[] {'c', 'f', 'j'}, 'g', 'j'),
          arguments(new char[] {'c', 'f', 'j'}, 'j', 'c'),
          arguments(new char[] {'c', 'f', 'j'}, 'k', 'c'));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nextGreatestLetter(char[] letters, char target, char expectedResult) {

    char actualResult = solution.nextGreatestLetter(letters, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
