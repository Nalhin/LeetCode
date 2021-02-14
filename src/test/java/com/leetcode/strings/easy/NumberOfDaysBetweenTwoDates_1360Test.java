package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfDaysBetweenTwoDates_1360Test {

  private final NumberOfDaysBetweenTwoDates_1360 solution = new NumberOfDaysBetweenTwoDates_1360();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("2019-06-29", "2019-06-30", 1),
          arguments("2020-01-15", "2019-12-31", 15),
          arguments("2074-09-12", "1983-01-08", 33485));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void daysBetweenDates(String date1, String date2, int expectedResult) {
    int actualResult = solution.daysBetweenDates(date1, date2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
