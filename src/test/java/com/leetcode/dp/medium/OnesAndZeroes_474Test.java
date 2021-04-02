package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OnesAndZeroes_474Test {
  private final OnesAndZeroes_474 solution = new OnesAndZeroes_474();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3, 4),
          arguments(new String[] {"10", "0", "1"}, 1, 1, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMaxForm(String[] strings, int m, int n, int expectedResult) {
    int actualResult = solution.findMaxForm(strings, m, n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
