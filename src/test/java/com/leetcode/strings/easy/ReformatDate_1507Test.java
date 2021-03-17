package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReformatDate_1507Test {
  private final ReformatDate_1507 solution = new ReformatDate_1507();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("20th Oct 2052", "2052-10-20"),
          arguments("6th Jun 1933", "1933-06-06"),
          arguments("26th May 1960", "1960-05-26"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reformatDate(String str, String expectedResult) {
    String actualResult = solution.reformatDate(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
