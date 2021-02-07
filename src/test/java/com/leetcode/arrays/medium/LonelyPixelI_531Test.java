package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LonelyPixelI_531Test {

  private final LonelyPixelI_531 solution = new LonelyPixelI_531();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new char[][] {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}}, 3),
          arguments(new char[][] {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLonelyPixel(char[][] input, int expectedResult) {
    int actualResult = solution.findLonelyPixel(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
