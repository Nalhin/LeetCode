package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfAStringCanBreakAnotherString_1433Test {

  private final CheckIfAStringCanBreakAnotherString_1433 solution =
      new CheckIfAStringCanBreakAnotherString_1433();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abc", "xya", true),
          arguments("abe", "acd", false),
          arguments("leetcodee", "interview", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void checkIfCanBreak(String s1, String s2, boolean expectedResult) {
    boolean actualResult = solution.checkIfCanBreak(s1, s2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
