package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DetermineColorOfAChessboardSquare_1812Test {
  private final DetermineColorOfAChessboardSquare_1812 solution =
      new DetermineColorOfAChessboardSquare_1812();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("a1", false), arguments("h3", true), arguments("c7", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void squareIsWhite(String coordinates, boolean expectedResult) {
    boolean actualResult = solution.squareIsWhite(coordinates);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
