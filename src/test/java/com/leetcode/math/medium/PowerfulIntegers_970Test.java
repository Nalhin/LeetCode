package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PowerfulIntegers_970Test {
  private final PowerfulIntegers_970 solution = new PowerfulIntegers_970();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(2, 3, 10, List.of(2, 3, 4, 5, 7, 9, 10)),
          arguments(3, 5, 15, List.of(2, 4, 6, 8, 10, 14)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void powerfulIntegers(int x, int y, int bound, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.powerfulIntegers(x, y, bound);

    assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
  }
}
