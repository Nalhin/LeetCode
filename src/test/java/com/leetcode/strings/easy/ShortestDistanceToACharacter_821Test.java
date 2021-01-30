package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortestDistanceToACharacter_821Test {

  private final ShortestDistanceToACharacter_821 solution = new ShortestDistanceToACharacter_821();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("loveleetcode", 'e', new int[] {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shortestToChar(String str, char c, int[] expectedResult) {
    int[] actualResult = solution.shortestToChar(str, c);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
