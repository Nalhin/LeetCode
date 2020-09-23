package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckIfNAndItsDoubleExists_1346Test {

  private final CheckIfNAndItsDoubleExists_1346 solution = new CheckIfNAndItsDoubleExists_1346();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {10, 2, 5, 3}, true),
          arguments(new int[] {7, 1, 14, 11}, true),
          arguments(new int[] {3, 1, 7, 11}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void checkIfExist(int[] input, boolean expectedResult) {

    boolean actualResult = solution.checkIfExist(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
