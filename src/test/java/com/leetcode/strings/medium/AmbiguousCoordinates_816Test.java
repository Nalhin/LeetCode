package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AmbiguousCoordinates_816Test {

  private final AmbiguousCoordinates_816 solution = new AmbiguousCoordinates_816();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("(123)", List.of("(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)")),
          arguments("(00011)", List.of("(0.001, 1)", "(0, 0.011)")),
          arguments(
              "(0123)",
              List.of(
                  "(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)")),
          arguments("(100)", List.of("(10, 0)")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void ambiguousCoordinates(String str, List<String> expectedResult) {
    List<String> actualResult = solution.ambiguousCoordinates(str);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
