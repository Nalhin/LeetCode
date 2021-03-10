package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumNumberOfVowelsInASubstringOfGivenLength_1456Test {

  private final MaximumNumberOfVowelsInASubstringOfGivenLength_1456 solution =
      new MaximumNumberOfVowelsInASubstringOfGivenLength_1456();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abciiidef", 3, 3),
          arguments("aeiou", 2, 2),
          arguments("leetcode", 3, 2),
          arguments("rhythms", 4, 0),
          arguments("tryhard", 4, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxVowels(String input, int k, int expectedResult) {
    int actualResult = solution.maxVowels(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
