package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConsecutiveCharacters_1446Test {

  private final ConsecutiveCharacters_1446 solution = new ConsecutiveCharacters_1446();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("leetcode", 2),
          arguments("abbcccddddeeeeedcba", 5),
          arguments("triplepillooooow", 5),
          arguments("hooraaaaaaaaaaay", 11),
          arguments("tourist", 1),
          arguments("abbcccddddeeeeedcba", 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxPower(String str, int expectedResult) {

    int actualResult = solution.maxPower(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
