package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DetermineIfStringHalvesAreAlike_1704Test {
  private final DetermineIfStringHalvesAreAlike_1704 solution =
      new DetermineIfStringHalvesAreAlike_1704();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("book", true),
          arguments("textbook", false),
          arguments("MerryChristmas", false),
          arguments("AbCdEfGh", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void halvesAreAlike(String str, boolean expectedResult) {
    boolean actualResult = solution.halvesAreAlike(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
