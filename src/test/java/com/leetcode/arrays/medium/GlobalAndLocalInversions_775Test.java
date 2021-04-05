package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GlobalAndLocalInversions_775Test {
  private final GlobalAndLocalInversions_775 solution = new GlobalAndLocalInversions_775();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {1, 0, 2}, true), arguments(new int[] {1, 2, 0}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isIdealPermutation(int[] arr, boolean expectedResult) {
    boolean actualResult = solution.isIdealPermutation(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
