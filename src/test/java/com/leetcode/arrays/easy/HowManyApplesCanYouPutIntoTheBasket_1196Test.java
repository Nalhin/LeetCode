package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HowManyApplesCanYouPutIntoTheBasket_1196Test {

  private final HowManyApplesCanYouPutIntoTheBasket_1196 solution =
      new HowManyApplesCanYouPutIntoTheBasket_1196();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {100, 200, 150, 1000}, 4),
          arguments(new int[] {900, 950, 800, 1000, 700, 800}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxNumberOfApples(int[] input, int expectedResult) {
    int actualResult = solution.maxNumberOfApples(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
