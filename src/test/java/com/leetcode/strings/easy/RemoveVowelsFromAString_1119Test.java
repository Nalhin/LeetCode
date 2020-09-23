package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveVowelsFromAString_1119Test {

  RemoveVowelsFromAString_1119 solution = new RemoveVowelsFromAString_1119();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("leetcodeisacommunityforcoders", "ltcdscmmntyfrcdrs"),
          arguments("aeiou", ""),
          arguments("", ""));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeVowels(String input, String expectedResult) {

    String actualResult = solution.removeVowels(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
