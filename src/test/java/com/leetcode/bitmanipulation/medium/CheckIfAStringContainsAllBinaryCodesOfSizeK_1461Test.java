package com.leetcode.bitmanipulation.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfAStringContainsAllBinaryCodesOfSizeK_1461Test {
  private final CheckIfAStringContainsAllBinaryCodesOfSizeK_1461 solution =
      new CheckIfAStringContainsAllBinaryCodesOfSizeK_1461();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("00110110", 2, true),
          arguments("00110", 2, true),
          arguments("0110", 1, true),
          arguments("0110", 2, false),
          arguments("0000000001011100", 4, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void hasAllCodes(String str, int k, boolean expectedResult) {
    boolean actualResult = solution.hasAllCodes(str, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
