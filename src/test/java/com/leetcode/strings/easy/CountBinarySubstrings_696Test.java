package com.leetcode.strings.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountBinarySubstrings_696Test {

  private final CountBinarySubstrings_696 solution = new CountBinarySubstrings_696();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("00110011", 6),
          arguments("10101", 4),
          arguments("101011111101010000000000", 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countBinarySubstrings(String str, int expectedResult) {
    int actualResult = solution.countBinarySubstrings(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
