package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ExcelSheetColumnTitle_168Test {

  private final ExcelSheetColumnTitle_168 solution = new ExcelSheetColumnTitle_168();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, "A"), arguments(28, "AB"), arguments(701, "ZY"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void convertToTitle(int n, String expectedResult) {
    String actualResult = solution.convertToTitle(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
