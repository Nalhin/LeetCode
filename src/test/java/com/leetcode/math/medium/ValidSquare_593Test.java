package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidSquare_593Test {

  private final ValidSquare_593 solution = new ValidSquare_593();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {0, 0}, new int[] {1, 1}, new int[] {1, 0}, new int[] {0, 1}, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void validSquare(int[] p1, int[] p2, int[] p3, int[] p4, boolean expectedResult) {
    boolean actualResult = solution.validSquare(p1, p2, p3, p4);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
