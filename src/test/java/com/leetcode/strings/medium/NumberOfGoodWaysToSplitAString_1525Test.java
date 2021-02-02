package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfGoodWaysToSplitAString_1525Test {

  private final NumberOfGoodWaysToSplitAString_1525 solution =
      new NumberOfGoodWaysToSplitAString_1525();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("aacaba", 2),
          arguments("abcd", 1),
          arguments("aaaaa", 4),
          arguments("acbadbaada", 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numSplits(String input, int expectedResult) {
    int actualResult = solution.numSplits(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
