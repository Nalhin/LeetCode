package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountVowelsPermutation_1220Test {

  private final CountVowelsPermutation_1220.TopDown solutionTopDown =
      new CountVowelsPermutation_1220.TopDown();
  private final CountVowelsPermutation_1220.BottomUp solutionBottomUp =
      new CountVowelsPermutation_1220.BottomUp();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(1, 5), arguments(2, 10), arguments(5, 68));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countVowelPermutationTopDown(int n, int expectedResult) {
    int actualResult = solutionTopDown.countVowelPermutation(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countVowelPermutationBottomUp(int n, int expectedResult) {
    int actualResult = solutionBottomUp.countVowelPermutation(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
