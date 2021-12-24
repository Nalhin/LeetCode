package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindFirstPalindromicStringInTheArray_2108Test {
  private final FindFirstPalindromicStringInTheArray_2108 solution =
      new FindFirstPalindromicStringInTheArray_2108();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"abc", "car", "ada", "racecar", "cool"}, "ada"),
          arguments(new String[] {"notapalindrome", "racecar"}, "racecar"),
          arguments(new String[] {"def", "ghi"}, ""));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void firstPalindrome(String[] words, String expectedResult) {
    String actualResult = solution.firstPalindrome(words);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
