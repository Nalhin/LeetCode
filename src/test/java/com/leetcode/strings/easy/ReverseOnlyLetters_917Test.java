package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseOnlyLetters_917Test {

  private final ReverseOnlyLetters_917 solution = new ReverseOnlyLetters_917();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("ab-cd", "dc-ba"),
          arguments("a-bC-dEf-ghIj", "j-Ih-gfE-dCba"),
          arguments("Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reverseOnlyLetters(String input, String expectedResult) {
    String actualResult = solution.reverseOnlyLetters(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
