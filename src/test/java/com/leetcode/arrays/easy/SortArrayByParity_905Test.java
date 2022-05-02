package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortArrayByParity_905Test {

  private final SortArrayByParity_905.InPlace solutionInPlace = new SortArrayByParity_905.InPlace();
  private final SortArrayByParity_905.NewOutput solutionNewOutput =
      new SortArrayByParity_905.NewOutput();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(new int[] {3, 2}, new int[] {2, 3}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sortArrayByParityInPlace(int[] input, int[] expectedResult) {
    int[] actualResult = solutionInPlace.sortArrayByParity(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sortArrayByParityNewOutput(int[] input, int[] expectedResult) {
    int[] actualResult = solutionNewOutput.sortArrayByParity(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
