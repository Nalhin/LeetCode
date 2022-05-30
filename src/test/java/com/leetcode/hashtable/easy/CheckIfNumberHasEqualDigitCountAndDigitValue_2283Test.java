package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfNumberHasEqualDigitCountAndDigitValue_2283Test {

  private final CheckIfNumberHasEqualDigitCountAndDigitValue_2283 solution =
      new CheckIfNumberHasEqualDigitCountAndDigitValue_2283();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("1210", true),
          arguments("030", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void digitCount(String num, boolean expectedResult) {
    boolean actualResult = solution.digitCount(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
