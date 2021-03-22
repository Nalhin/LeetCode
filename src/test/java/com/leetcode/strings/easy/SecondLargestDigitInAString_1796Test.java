package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SecondLargestDigitInAString_1796Test {

  private final SecondLargestDigitInAString_1796 solution = new SecondLargestDigitInAString_1796();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("dfa12321afd", 2), arguments("abc1111", -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void secondHighest(String str, int expectedResult) {
    int actualResult = solution.secondHighest(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
