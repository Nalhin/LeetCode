package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfSegmentsInAString_434Test {

  private final NumberOfSegmentsInAString_434 solution = new NumberOfSegmentsInAString_434();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("Hello, my name is John", 5),
          arguments("Hello", 1),
          arguments("love live! mu'sic forever", 4),
          arguments("", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countSegments(String str, int expectedResult) {

    int actualResult = solution.countSegments(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
