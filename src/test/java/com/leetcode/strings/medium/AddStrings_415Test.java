package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AddStrings_415Test {
  private final AddStrings_415 solution = new AddStrings_415();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("0", "0", "0"), arguments("9999", "999", "10998"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void calculate(String num1, String num2, String expectedResult) {
    String actualResult = solution.addStrings(num1, num2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
