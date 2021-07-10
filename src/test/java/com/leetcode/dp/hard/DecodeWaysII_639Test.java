package com.leetcode.dp.hard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DecodeWaysII_639Test {

  private final DecodeWaysII_639 solution = new DecodeWaysII_639();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("*", 9), arguments("1*", 18), arguments("2*", 15));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxCoins(String str, int expectedResult) {
    int actualResult = solution.numDecodings(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  void numDecodings() {}
}
