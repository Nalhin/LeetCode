package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumScoreAfterSplittingAString_1422Test {

  private final MaximumScoreAfterSplittingAString_1422 solution =
      new MaximumScoreAfterSplittingAString_1422();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("011101", 5), arguments("00111", 5), arguments("1111", 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxScore(String str, int expectedResult) {
    int actualResult = solution.maxScore(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
