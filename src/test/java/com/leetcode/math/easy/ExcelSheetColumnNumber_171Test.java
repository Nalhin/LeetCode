package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ExcelSheetColumnNumber_171Test {

  private final ExcelSheetColumnNumber_171 solution = new ExcelSheetColumnNumber_171();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("A", 1), arguments("AB", 28), arguments("ZY", 701));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void titleToNumber(String columnTitle, int expectedResult) {
    int actualResult = solution.titleToNumber(columnTitle);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
