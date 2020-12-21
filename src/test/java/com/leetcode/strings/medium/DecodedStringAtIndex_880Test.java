package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DecodedStringAtIndex_880Test {

  private final DecodedStringAtIndex_880 solution = new DecodedStringAtIndex_880();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("leet2code3", 10, "o"),
          arguments("ha22", 5, "h"),
          arguments("a2345678999999999999999", 1, "a"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void decodeAtIndex(String str, int k, String expectedResult) {
    String actualResult = solution.decodeAtIndex(str, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
